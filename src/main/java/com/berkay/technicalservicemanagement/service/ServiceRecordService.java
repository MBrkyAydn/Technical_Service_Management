package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.ServiceRecordCreateRequest;
import com.berkay.technicalservicemanagement.dto.ServiceRecordResponse;
import com.berkay.technicalservicemanagement.dto.ServiceStatusUpdateRequest;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.entity.ServiceRecord;
import com.berkay.technicalservicemanagement.entity.ServiceStatus;
import com.berkay.technicalservicemanagement.entity.Technician;
import com.berkay.technicalservicemanagement.exception.DeviceNotFoundException;
import com.berkay.technicalservicemanagement.exception.InvalidServiceStatusTransitionException;
import com.berkay.technicalservicemanagement.exception.ServiceRecordNotFoundException;
import com.berkay.technicalservicemanagement.exception.TechnicianNotFoundException;
import com.berkay.technicalservicemanagement.mapper.ServiceRecordMapper;
import com.berkay.technicalservicemanagement.repository.DeviceRepository;
import com.berkay.technicalservicemanagement.repository.ServiceRecordRepository;
import com.berkay.technicalservicemanagement.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceRecordService {

    private final DeviceRepository deviceRepository;
    private final TechnicianRepository technicianRepository;
    private final ServiceRecordRepository serviceRecordRepository;
    private final ServiceRecordMapper serviceRecordMapper;

    public ServiceRecordResponse createServiceRecord(
            ServiceRecordCreateRequest request) {

        Device device = deviceRepository.findById(request.getDeviceId())
                .orElseThrow(() ->
                        new DeviceNotFoundException(
                                "Cihaz bulunamadı : " + request.getDeviceId()));

        Technician technician = technicianRepository.findById(request.getTechnicianId())
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + request.getTechnicianId()));

        ServiceRecord serviceRecord =
                serviceRecordMapper.toEntity(request, device, technician);

        device.addServiceRecord(serviceRecord);

        serviceRecord.setServiceDate(LocalDateTime.now());
        serviceRecord.setStatus(ServiceStatus.BEKLEMEDE);

        ServiceRecord savedServiceRecord =
                serviceRecordRepository.save(serviceRecord);

        return serviceRecordMapper.toResponse(savedServiceRecord);
    }

    public List<ServiceRecordResponse> getAllServiceRecords() {

        return serviceRecordRepository.findAll()
                .stream()
                .map(serviceRecordMapper::toResponse)
                .toList();
    }

    public ServiceRecordResponse getServiceRecord(Long id) {

        ServiceRecord serviceRecord = serviceRecordRepository.findById(id)
                .orElseThrow(() ->
                        new ServiceRecordNotFoundException(
                                "Servis kaydı bulunamadı : " + id));

        return serviceRecordMapper.toResponse(serviceRecord);
    }

    public ServiceRecordResponse updateStatus(
            Long id,
            ServiceStatusUpdateRequest request) {

        ServiceRecord serviceRecord = serviceRecordRepository.findById(id)
                .orElseThrow(() ->
                        new InvalidServiceStatusTransitionException(
                                "Servis kaydı bulunamadı : " + id));

        ServiceStatus currentStatus = serviceRecord.getStatus();
        ServiceStatus newStatus = request.getStatus();

        if (currentStatus == ServiceStatus.BEKLEMEDE) {

            if (newStatus != ServiceStatus.INCELENIYOR) {
                throw new InvalidServiceStatusTransitionException(
                        "BEKLEMEDE durumundaki servis sadece INCELENIYOR durumuna geçirilebilir");
            }

        } else if (currentStatus == ServiceStatus.INCELENIYOR) {

            if (newStatus != ServiceStatus.PARCA_BEKLIYOR
                    && newStatus != ServiceStatus.TAMIR_EDILIYOR) {

                throw new InvalidServiceStatusTransitionException(
                        "INCELENIYOR durumundaki servis PARCA_BEKLIYOR veya TAMIR_EDILIYOR durumuna geçirilebilir");
            }

        } else if (currentStatus == ServiceStatus.PARCA_BEKLIYOR) {

            if (newStatus != ServiceStatus.TAMIR_EDILIYOR) {
                throw new InvalidServiceStatusTransitionException(
                        "PARCA_BEKLIYOR durumundaki servis sadece TAMIR_EDILIYOR durumuna geçirilebilir");
            }

        } else if (currentStatus == ServiceStatus.TAMIR_EDILIYOR) {

            if (newStatus != ServiceStatus.TAMAMLANDI) {
                throw new InvalidServiceStatusTransitionException(
                        "TAMIR_EDILIYOR durumundaki servis sadece TAMAMLANDI durumuna geçirilebilir");
            }

        } else if (currentStatus == ServiceStatus.TAMAMLANDI) {

            if (newStatus != ServiceStatus.TESLIM_EDILDI) {
                throw new InvalidServiceStatusTransitionException(
                        "TAMAMLANDI durumundaki servis sadece TESLIM_EDILDI durumuna geçirilebilir");
            }

        } else if (currentStatus == ServiceStatus.TESLIM_EDILDI) {

            throw new InvalidServiceStatusTransitionException(
                    "TESLIM_EDILDI durumundaki servis değiştirilemez");
        }

        serviceRecord.setStatus(newStatus);

        ServiceRecord updatedServiceRecord =
                serviceRecordRepository.save(serviceRecord);

        return serviceRecordMapper.toResponse(updatedServiceRecord);
    }
}

package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.DeviceCreateRequest;
import com.berkay.technicalservicemanagement.dto.DeviceResponse;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.exception.CustomerNotFoundException;
import com.berkay.technicalservicemanagement.exception.DeviceNotFoundException;
import com.berkay.technicalservicemanagement.mapper.DeviceMapper;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import com.berkay.technicalservicemanagement.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final CustomerRepository customerRepository;
    private final DeviceMapper deviceMapper;

    public DeviceResponse createDevice(DeviceCreateRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException("Müşteri Bulunamadı"));

        Device device = deviceMapper.toEntity(request, customer);
        Device savedDevice = deviceRepository.save(device);

        return deviceMapper.toResponse(savedDevice);
    }

    public List<DeviceResponse> getAllDevices() {

        return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::toResponse)
                .toList();
    }

    public DeviceResponse getDevice(Long id) {

        Device device = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new DeviceNotFoundException("Cihaz Bulunamadı : " + id));

        return deviceMapper.toResponse(device);
    }

    public DeviceResponse updateDevice(Long id, DeviceCreateRequest request) {

        Device device = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new DeviceNotFoundException("Device : " + id));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Müşteri bulunamadı : " + request.getCustomerId()));

        device.setType(request.getType());
        device.setBrand(request.getBrand());
        device.setModel(request.getModel());
        device.setSerialNumber(request.getSerialNumber());
        device.setCustomer(customer);

        Device updatedDevice = deviceRepository.save(device);

        return deviceMapper.toResponse(updatedDevice);
    }

    @Transactional
    public void deleteDevice(Long id) {

        Device device = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new DeviceNotFoundException("Device : " + id));

        if (device.getServiceRecords() != null && !device.getServiceRecords().isEmpty()) {
            throw new IllegalStateException("Bu cihaza ait servis kaydı bulunduğu için cihaz silinemez");
        }

        deviceRepository.delete(device);
    }

    public List<DeviceResponse> getDevicesByCustomerId(Long customerId) {

        return deviceRepository.findByCustomerId(customerId)
                .stream()
                .map(deviceMapper::toResponse)
                .toList();
    }
}
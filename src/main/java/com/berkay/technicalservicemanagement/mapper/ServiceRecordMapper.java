package com.berkay.technicalservicemanagement.mapper;

import com.berkay.technicalservicemanagement.dto.ServiceRecordCreateRequest;
import com.berkay.technicalservicemanagement.dto.ServiceRecordResponse;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.entity.ServiceRecord;
import com.berkay.technicalservicemanagement.entity.Technician;
import org.springframework.stereotype.Component;

@Component
public class ServiceRecordMapper {

    public ServiceRecord toEntity(
            ServiceRecordCreateRequest request,
            Device device,
            Technician technician) {

        ServiceRecord serviceRecord = new ServiceRecord();

        serviceRecord.setDevice(device);
        serviceRecord.setTechnician(technician);
        serviceRecord.setFaultDescription(request.getFaultDescription());
        serviceRecord.setRepairDetails(request.getRepairDetails());
        serviceRecord.setPrice(request.getPrice());

        return serviceRecord;
    }

    public ServiceRecordResponse toResponse(ServiceRecord serviceRecord) {

        ServiceRecordResponse response = new ServiceRecordResponse();

        response.setId(serviceRecord.getId());

        response.setCustomerName(
                serviceRecord.getDevice().getCustomer().getFirstName()
                        + " "
                        + serviceRecord.getDevice().getCustomer().getLastName()
        );

        response.setDevice(
                serviceRecord.getDevice().getBrand()
                        + " "
                        + serviceRecord.getDevice().getModel()
        );

        response.setTechnicianName(
                serviceRecord.getTechnician().getFirstName()
                        + " "
                        + serviceRecord.getTechnician().getLastName()
        );

        response.setFaultDescription(serviceRecord.getFaultDescription());
        response.setRepairDetails(serviceRecord.getRepairDetails());
        response.setPrice(serviceRecord.getPrice());
        response.setServiceDate(serviceRecord.getServiceDate());
        response.setStatus(serviceRecord.getStatus());

        return response;
    }
}
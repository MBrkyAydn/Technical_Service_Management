package com.berkay.technicalservicemanagement.mapper;

import com.berkay.technicalservicemanagement.dto.DeviceCreateRequest;
import com.berkay.technicalservicemanagement.dto.DeviceResponse;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    public DeviceResponse toResponse(Device device) {
        DeviceResponse response = new DeviceResponse();

        response.setType(device.getType());
        response.setBrand(device.getBrand());
        response.setModel(device.getModel());
        response.setSerialNumber(device.getSerialNumber());

        return response;
    }
    public Device toEntity(DeviceCreateRequest request, Customer customer) {

        Device device = new Device();

        device.setType(request.getType());
        device.setBrand(request.getBrand());
        device.setModel(request.getModel());
        device.setSerialNumber(request.getSerialNumber());
        device.setCustomer(customer);

        return device;
    }
}

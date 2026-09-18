package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.DeviceCreateRequest;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.exception.CustomerNotFoundException;
import com.berkay.technicalservicemanagement.exception.DeviceNotFoundException;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import com.berkay.technicalservicemanagement.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final CustomerRepository customerRepository;

    public Device createDevice(DeviceCreateRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Müşteri Bulunamadı"));
        Device device = new Device(
                request.getType(),
                request.getBrand(),
                request.getModel(),
                request.getSerialNumber(), customer);
        return deviceRepository.save(device);

    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDevice(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new DeviceNotFoundException("Cihaz Bulunamadı : " + id));


    }

    public Device updateDevice(Long id, DeviceCreateRequest request) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("Device : " + id));
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException("Müşteri bulunamadı : "
                                + request.getCustomerId()));
        device.setBrand(request.getBrand());
        device.setModel(request.getModel());
        device.setSerialNumber(request.getSerialNumber());

        device.setCustomer(customer);

        return deviceRepository.save(device);

    }

    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("Device : " + id));
        deviceRepository.delete(device);


    }
    public List<Device> getDevicesByCustomerId(Long customerId) {

        return deviceRepository.findByCustomerId(customerId);
    }

}

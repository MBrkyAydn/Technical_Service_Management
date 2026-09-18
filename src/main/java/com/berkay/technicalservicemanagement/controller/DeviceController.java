package com.berkay.technicalservicemanagement.controller;


import com.berkay.technicalservicemanagement.dto.DeviceCreateRequest;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.repository.DeviceRepository;
import com.berkay.technicalservicemanagement.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public Device addDevice(@Valid @RequestBody DeviceCreateRequest device) {
        return deviceService.createDevice(device);

//@Valid, dışarıdan gelen verinin (JSON/DTO) geçerlilik kurallarına (@NotBlank, @NotNull, @Min vb.)
// uyup uymadığını kontrol eden ve kural ihlali varsa isteği reddedip otomatik hata fırlatan doğrulama bekçisidir.
    }

    @GetMapping("/{id}")
    public Device getDevice(@PathVariable Long id) {
        return deviceService.getDevice(id);
    }

    @PutMapping("/{id}")
    public Device updateDevice(@PathVariable Long id, @Valid @RequestBody DeviceCreateRequest request) {
        return deviceService.updateDevice(id, request);


    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);

    }
    @GetMapping("/customer/{customerId}")
    public List<Device> getDevicesByCustomerId(
            @PathVariable Long customerId) {

        return deviceService.getDevicesByCustomerId(customerId);
    }
}

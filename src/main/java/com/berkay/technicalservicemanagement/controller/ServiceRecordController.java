package com.berkay.technicalservicemanagement.controller;

import com.berkay.technicalservicemanagement.dto.ServiceRecordCreateRequest;
import com.berkay.technicalservicemanagement.dto.ServiceRecordResponse;
import com.berkay.technicalservicemanagement.dto.ServiceStatusUpdateRequest;
import com.berkay.technicalservicemanagement.entity.ServiceRecord;
import com.berkay.technicalservicemanagement.service.ServiceRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service-records")
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;

    @PostMapping
    public ServiceRecord createServiceRecord(
            @Valid @RequestBody ServiceRecordCreateRequest request) {

        return serviceRecordService.createServiceRecord(request);
    }

    @GetMapping
    public List<ServiceRecordResponse> getAllServiceRecords() {
        return serviceRecordService.getAllServiceRecords();
    }

    @GetMapping("/{id}")
    public ServiceRecordResponse getServiceRecord(@PathVariable Long id) {
        return serviceRecordService.getServiceRecord(id);
    }

    @PatchMapping("/{id}/status") //  Bir kaynağın tüm alanlarını değil, sadece belirli bir veya birkaç alanını kısmi
    // olarak güncellemek (partial update) amacıyla kullanılır.
    public ServiceRecord updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody ServiceStatusUpdateRequest request) {

        return serviceRecordService.updateStatus(id, request);
    }

}
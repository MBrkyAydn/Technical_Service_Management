package com.berkay.technicalservicemanagement.controller;

import com.berkay.technicalservicemanagement.dto.TechnicianCreateRequest;
import com.berkay.technicalservicemanagement.dto.TechnicianResponse;
import com.berkay.technicalservicemanagement.service.TechnicianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    @PostMapping
    public TechnicianResponse createTechnician(
            @Valid @RequestBody TechnicianCreateRequest request) {

        return technicianService.createTechnician(request);
    }

    @GetMapping
    public List<TechnicianResponse> getAllTechnicians() {
        return technicianService.getAllTechnicians();
    }

    @GetMapping("/{id}")
    public TechnicianResponse getTechnician(@PathVariable Long id) {
        return technicianService.getTechnician(id);
    }

    @PutMapping("/{id}")
    public TechnicianResponse updateTechnician(
            @PathVariable Long id,
            @Valid @RequestBody TechnicianCreateRequest request) {

        return technicianService.updateTechnician(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnician(@PathVariable Long id) {
        technicianService.deleteTechnician(id);
    }
}
package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.TechnicianCreateRequest;
import com.berkay.technicalservicemanagement.dto.TechnicianResponse;
import com.berkay.technicalservicemanagement.entity.Technician;
import com.berkay.technicalservicemanagement.exception.TechnicianNotFoundException;
import com.berkay.technicalservicemanagement.mapper.TechnicianMapper;
import com.berkay.technicalservicemanagement.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianService {

    private final TechnicianRepository technicianRepository;
    private final TechnicianMapper technicianMapper;

    public TechnicianResponse createTechnician(TechnicianCreateRequest request) {

        Technician technician = technicianMapper.toEntity(request);

        Technician savedTechnician = technicianRepository.save(technician);

        return technicianMapper.toResponse(savedTechnician);
    }

    public List<TechnicianResponse> getAllTechnicians() {

        return technicianRepository.findAll()
                .stream()
                .map(technicianMapper::toResponse)
                .toList();
    }

    public TechnicianResponse getTechnician(Long id) {

        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + id));

        return technicianMapper.toResponse(technician);
    }

    public TechnicianResponse updateTechnician(
            Long id,
            TechnicianCreateRequest request) {

        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + id));

        technician.setFirstName(request.getFirstName());
        technician.setLastName(request.getLastName());
        technician.setSpecialization(request.getSpecialization());
        technician.setPhone(request.getPhone());

        Technician updatedTechnician = technicianRepository.save(technician);

        return technicianMapper.toResponse(updatedTechnician);
    }

    public void deleteTechnician(Long id) {

        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + id));

        technicianRepository.delete(technician);
    }
}
package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.TechnicianCreateRequest;
import com.berkay.technicalservicemanagement.entity.Technician;
import com.berkay.technicalservicemanagement.exception.TechnicianNotFoundException;
import com.berkay.technicalservicemanagement.repository.TechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicianService {

    private final TechnicianRepository technicianRepository;

    public Technician createTechnician(TechnicianCreateRequest request) {

        Technician technician = new Technician(
                request.getFirstName(),
                request.getLastName(),
                request.getSpecialization(),
                request.getPhone()
        );

        return technicianRepository.save(technician);
    }

    public List<Technician> getAllTechnicians() {
        return technicianRepository.findAll();
    }

    public Technician getTechnician(Long id) {

        return technicianRepository.findById(id)
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + id));
    }

    public Technician updateTechnician(
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

        return technicianRepository.save(technician);
    }

    public void deleteTechnician(Long id) {

        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() ->
                        new TechnicianNotFoundException(
                                "Teknisyen bulunamadı : " + id));

        technicianRepository.delete(technician);
    }
}
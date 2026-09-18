package com.berkay.technicalservicemanagement.mapper;

import com.berkay.technicalservicemanagement.dto.TechnicianCreateRequest;
import com.berkay.technicalservicemanagement.dto.TechnicianResponse;
import com.berkay.technicalservicemanagement.entity.Technician;
import org.springframework.stereotype.Component;

@Component
public class TechnicianMapper {

    public Technician toEntity(TechnicianCreateRequest request) {

        Technician technician = new Technician();

        technician.setFirstName(request.getFirstName());
        technician.setLastName(request.getLastName());
        technician.setSpecialization(request.getSpecialization());
        technician.setPhone(request.getPhone());

        return technician;
    }

    public TechnicianResponse toResponse(Technician technician) {

        TechnicianResponse response = new TechnicianResponse();

        response.setId(technician.getId());
        response.setFirstName(technician.getFirstName());
        response.setLastName(technician.getLastName());
        response.setSpecialization(technician.getSpecialization());
        response.setPhone(technician.getPhone());

        return response;
    }
}
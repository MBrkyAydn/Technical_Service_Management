package com.berkay.technicalservicemanagement.dto;

import com.berkay.technicalservicemanagement.entity.ServiceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceStatusUpdateRequest {

    @NotNull(message = "Durum boş bırakılamaz")
    private ServiceStatus status;
}
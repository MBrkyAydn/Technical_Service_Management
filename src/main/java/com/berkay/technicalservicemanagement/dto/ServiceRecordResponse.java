package com.berkay.technicalservicemanagement.dto;

import com.berkay.technicalservicemanagement.entity.ServiceStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServiceRecordResponse {
    private Long id;

    private String customerName;

    private String device;

    private String technicianName;

    private String faultDescription;

    private String repairDetails;

    private Double price;

    private LocalDateTime serviceDate;

    private ServiceStatus status;

}

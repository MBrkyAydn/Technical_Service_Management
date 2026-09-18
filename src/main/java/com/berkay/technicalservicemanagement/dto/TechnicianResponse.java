package com.berkay.technicalservicemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicianResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phone;
}
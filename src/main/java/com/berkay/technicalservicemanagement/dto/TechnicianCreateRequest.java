package com.berkay.technicalservicemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicianCreateRequest {

    @NotBlank(message = "Ad boş bırakılamaz")
    private String firstName;

    @NotBlank(message = "Soyad boş bırakılamaz")
    private String lastName;

    @NotBlank(message = "Uzmanlık alanı boş bırakılamaz")
    private String specialization;

    @NotBlank(message = "Telefon boş bırakılamaz")
    private String phone;
}
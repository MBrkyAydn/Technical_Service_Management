package com.berkay.technicalservicemanagement.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceCreateRequest {

    @NotBlank(message = "Cihaz tipi boş bırakılamaz")
    private String type;

    @NotBlank(message = "Marka boş bırakılamaz")
    private String brand;

    @NotBlank(message = "Model boş bırakılamaz")
    private String model;

    @NotBlank(message = "Seri numarası boş bırakılamaz")
    private String serialNumber;

    @NotNull(message = "Müşteri ID boş bırakılamaz")
    private Long customerId;
}

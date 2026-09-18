package com.berkay.technicalservicemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRecordCreateRequest {

    @NotNull(message = "Cihaz ID boş bırakılamaz")
    private Long deviceId;

    @NotNull(message = "Teknisyen ID boş bırakılamaz")
    private Long technicianId;

    @NotBlank(message = "Arıza açıklaması boş bırakılamaz")
    private String faultDescription;

    private String repairDetails;

    @NotNull(message = "Ücret boş bırakılamaz")
    @PositiveOrZero(message = "Ücret 0 veya daha büyük olmalıdır")
    private Double price;
}
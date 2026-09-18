package com.berkay.technicalservicemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}

package com.berkay.technicalservicemanagement.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateRequest {
    @NotBlank(message = "Ad Boş Bırakılamaz")
    private String firstName;
    @NotBlank(message = "Soyad Boş Bırakılamaz")
    private String lastName;
    @NotBlank(message = "Telefon Boş Bırakılamaz")
    private String phone;
    @NotBlank(message = "E-posta Boş Bırakılamaz")
    @Email(message = "Geçerli Bir E-posta Girin")
    private String email;
    @NotBlank(message = "Adres Boş Bırakılamaz")
    private String address;

}

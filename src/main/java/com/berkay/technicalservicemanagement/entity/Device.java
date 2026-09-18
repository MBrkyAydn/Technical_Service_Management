package com.berkay.technicalservicemanagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String brand;
    private String model;
    private String serialNumber;

    @ManyToOne // → Bir Customer'ın birden fazla Device'ı olabilir diyor.
    @JoinColumn(name = "customer_id") //Bu bağlantıyı Device tablosunda customer_id isimli sütunda tut diyor.
    private Customer customer; // Device ile Customer arasında bağlantı kurulacağını söylüyor.


    public Device(String type, String brand, String model,
                  String serialNumber, Customer customer) {

        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.customer = customer;
    }
}

package com.berkay.technicalservicemanagement.entity;


import jakarta.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

@OneToMany(mappedBy = "customer")
private List<Device> devicess = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}

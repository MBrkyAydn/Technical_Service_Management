package com.berkay.technicalservicemanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="service_records")
public class ServiceRecord extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    private String faultDescription;

    private String repairDetails;

    private Double price;

    private LocalDateTime serviceDate;

    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    public ServiceRecord(Device device, Technician technician, String faultDescription, String repairDetails, Double price, LocalDateTime serviceDate, ServiceStatus status) {
        this.device = device;
        this.technician = technician;
        this.faultDescription = faultDescription;
        this.repairDetails = repairDetails;
        this.price = price;
        this.serviceDate = serviceDate;
        this.status = status;


    }

}

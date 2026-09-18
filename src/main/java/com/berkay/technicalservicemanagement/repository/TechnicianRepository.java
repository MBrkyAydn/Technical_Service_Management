package com.berkay.technicalservicemanagement.repository;

import com.berkay.technicalservicemanagement.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
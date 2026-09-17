package com.berkay.technicalservicemanagement.repository;

import com.berkay.technicalservicemanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



}

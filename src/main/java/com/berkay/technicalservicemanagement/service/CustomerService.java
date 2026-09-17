package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
private final CustomerRepository customerRepository;

public List<Customer> getAllCustomers()
{
    return customerRepository.findAll();

}


}

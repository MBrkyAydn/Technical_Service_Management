package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import jakarta.validation.Valid;
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


    public Customer createCustomer(CustomerCreateRequest request) {
    Customer customer = new Customer(
            request.getFirstName(),
            request.getLastName(),
            request.getPhone(),
            request.getEmail(),
            request.getAddress()
    );

    return  customerRepository.save(customer);

    }
}

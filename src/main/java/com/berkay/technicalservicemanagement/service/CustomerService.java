package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.exception.CustomerNotFoundException;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import jakarta.validation.Valid;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }


    public Customer createCustomer(CustomerCreateRequest request) {
        Customer customer = new Customer(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getAddress(),
                request.getPhone()
        );
        return customerRepository.save(customer);

    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Müşteri Bulunamadı"));


    }

    public Customer updateCustomer(Long id, CustomerCreateRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Müşteri bulunamadı"));

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());

        return customerRepository.save(customer);
    }
public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Müşteri Bulunamadı"));

    customerRepository.delete(customer);


}

}

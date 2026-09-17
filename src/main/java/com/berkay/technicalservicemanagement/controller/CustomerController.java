package com.berkay.technicalservicemanagement.controller;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerCreateRequest request) {
        return customerService.createCustomer(request);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);

    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerCreateRequest request) {
        return customerService.updateCustomer(id, request);


    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);

    }

}

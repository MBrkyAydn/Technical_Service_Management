package com.berkay.technicalservicemanagement.controller;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.dto.CustomerResponse;
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
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerResponse createCustomer(
            @Valid @RequestBody CustomerCreateRequest request) {

        return customerService.createCustomer(request);
    }

    @GetMapping("/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerCreateRequest request) {

        return customerService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
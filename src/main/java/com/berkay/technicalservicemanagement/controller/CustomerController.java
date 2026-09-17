package com.berkay.technicalservicemanagement.controller;

import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
private final CustomerService customerService;

@GetMapping
public List<Customer> getAllCustomers()
{
  return customerService.getAllCustomers();
}



}

package com.berkay.technicalservicemanagement.mapper;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.dto.CustomerResponse;
import com.berkay.technicalservicemanagement.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        return customer;


    }
    public CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();

        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setPhone(customer.getPhone());
        response.setEmail(customer.getEmail());

        return response;
    }


}

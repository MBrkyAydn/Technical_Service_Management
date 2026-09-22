package com.berkay.technicalservicemanagement.service;

import com.berkay.technicalservicemanagement.dto.CustomerCreateRequest;
import com.berkay.technicalservicemanagement.dto.CustomerResponse;
import com.berkay.technicalservicemanagement.entity.Customer;
import com.berkay.technicalservicemanagement.entity.Device;
import com.berkay.technicalservicemanagement.exception.CustomerNotFoundException;
import com.berkay.technicalservicemanagement.mapper.CustomerMapper;
import com.berkay.technicalservicemanagement.repository.CustomerRepository;
import com.berkay.technicalservicemanagement.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final DeviceRepository deviceRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponse> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    public CustomerResponse createCustomer(CustomerCreateRequest request) {

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    public CustomerResponse findCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Müşteri Bulunamadı"));

        return customerMapper.toResponse(customer);
    }

    public CustomerResponse updateCustomer(
            Long id,
            CustomerCreateRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Müşteri bulunamadı"));

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }

    @Transactional
    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Müşteri Bulunamadı"));

        List<Device> devices = deviceRepository.findByCustomerId(id);
        devices.forEach(device -> device.setCustomer(null));
        deviceRepository.saveAll(devices);

        customerRepository.delete(customer);
    }
}

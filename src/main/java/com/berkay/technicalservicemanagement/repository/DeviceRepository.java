package com.berkay.technicalservicemanagement.repository;

import com.berkay.technicalservicemanagement.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository  extends JpaRepository<Device, Long> {
List<Device> findByCustomerId(Long customerId);
}

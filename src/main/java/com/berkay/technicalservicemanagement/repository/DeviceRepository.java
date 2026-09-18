package com.berkay.technicalservicemanagement.repository;

import com.berkay.technicalservicemanagement.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository  extends JpaRepository<Device, Long> {

}

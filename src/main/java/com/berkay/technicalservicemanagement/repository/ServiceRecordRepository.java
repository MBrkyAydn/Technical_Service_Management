package com.berkay.technicalservicemanagement.repository;

import com.berkay.technicalservicemanagement.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
}
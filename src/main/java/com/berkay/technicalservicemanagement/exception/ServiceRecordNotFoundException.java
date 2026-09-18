package com.berkay.technicalservicemanagement.exception;

public class ServiceRecordNotFoundException extends RuntimeException {
    public ServiceRecordNotFoundException(String message) {
        super(message);
    }
}

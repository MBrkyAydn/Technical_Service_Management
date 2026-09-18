package com.berkay.technicalservicemanagement.exception;

public class TechnicianNotFoundException extends RuntimeException {
    public TechnicianNotFoundException(String message) {
        super(message);
    }
}

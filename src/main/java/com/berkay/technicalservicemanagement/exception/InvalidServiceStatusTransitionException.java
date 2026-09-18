package com.berkay.technicalservicemanagement.exception;

public class InvalidServiceStatusTransitionException extends RuntimeException {
    public InvalidServiceStatusTransitionException(String message) {
        super(message);
    }
}

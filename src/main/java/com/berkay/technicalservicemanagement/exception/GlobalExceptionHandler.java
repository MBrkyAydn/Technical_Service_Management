package com.berkay.technicalservicemanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .getFirst().getDefaultMessage();

    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(DeviceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleDeviceNotFoundException(DeviceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(TechnicianNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTechnicianNotFoundException(TechnicianNotFoundException ex) {
        return ex.getMessage();


    }

    @ExceptionHandler(ServiceRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleServiceRecordNotFoundException(ServiceRecordNotFoundException ex) {
        return ex.getMessage();

    }
    @ExceptionHandler(InvalidServiceStatusTransitionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidServiceStatusTransitionException(InvalidServiceStatusTransitionException ex) {
          return   ex.getMessage();
    }
}

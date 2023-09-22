package com.khomsi.customer.handler.advice;

import com.khomsi.customer.handler.exception.CustomerIsFraudsterException;
import com.khomsi.customer.handler.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerExceptionControllerAdvice {
    @ExceptionHandler(CustomerIsFraudsterException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorDTO> customerIsFraudsterExceptionHandler(CustomerIsFraudsterException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorDTO(exception.getMessage()));
    }
}
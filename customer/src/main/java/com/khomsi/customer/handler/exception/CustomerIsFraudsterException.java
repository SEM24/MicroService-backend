package com.khomsi.customer.handler.exception;

public class CustomerIsFraudsterException extends RuntimeException {
    public CustomerIsFraudsterException() {
        super("This customer is fraudster");
    }
}

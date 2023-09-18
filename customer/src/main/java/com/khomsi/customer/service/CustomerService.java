package com.khomsi.customer.service;

import com.khomsi.customer.model.entity.Customer;
import com.khomsi.customer.model.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
    }
}
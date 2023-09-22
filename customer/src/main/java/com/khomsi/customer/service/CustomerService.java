package com.khomsi.customer.service;

import com.khomsi.clients.fraud.FraudClient;
import com.khomsi.clients.fraud.model.response.FraudCheckResponse;
import com.khomsi.customer.CustomerRepository;
import com.khomsi.customer.handler.exception.CustomerIsFraudsterException;
import com.khomsi.customer.model.entity.Customer;
import com.khomsi.customer.model.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
        CustomerRepository customerRepo,
        RestTemplate restTemplate,
        FraudClient fraudClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //To get the access to id after saving it instead of null id
        customerRepo.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.isFraudster()) {
            throw new CustomerIsFraudsterException();
        }
    }
}

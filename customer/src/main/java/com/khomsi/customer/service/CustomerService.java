package com.khomsi.customer.service;

import com.khomsi.amqp.RabbitMQMessageProducer;
import com.khomsi.clients.fraud.FraudCheckResponse;
import com.khomsi.clients.fraud.FraudClient;
import com.khomsi.clients.notification.NotificationRequest;
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
        FraudClient fraudClient,
        RabbitMQMessageProducer producer
) {
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
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(), customer.getEmail(),
                String.format("Hello %s, welcome to WebSite!", customer.getFirstName())
        );
        producer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}

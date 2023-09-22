package com.khomsi.customer.controller;

import com.khomsi.customer.model.request.CustomerRegistrationRequest;
import com.khomsi.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Tag(name = "Customer Controller", description = "CRUD for Customer Controller")
@RequestMapping("api/v1/customer")
public record CustomerController(CustomerService customerService) {
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        log.info("New registration {}", request);
        customerService.registerCustomer(request);
    }
}
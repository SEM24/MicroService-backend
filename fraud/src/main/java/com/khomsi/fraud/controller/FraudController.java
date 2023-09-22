package com.khomsi.fraud.controller;

import com.khomsi.clients.fraud.model.response.FraudCheckResponse;
import com.khomsi.fraud.service.FraudService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Tag(name = "Fraud Controller", description = "CRUD for Fraud Controller")
@RequestMapping("api/v1/fraud")
public record FraudController(FraudService fraudService) {
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Long customerId) {
        log.info("Fraud checks request for {}", customerId);
        return new FraudCheckResponse(fraudService.isFraudulentCustomer(customerId));
    }
}

package com.khomsi.clients.fraud;

import com.khomsi.clients.fraud.model.response.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {
    @GetMapping(path = "api/v1/fraud/{customerId}")
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") Long customerId);
}
package com.khomsi.fraud.service;

import com.khomsi.fraud.FraudRepository;
import com.khomsi.fraud.model.entity.FraudCheckHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudService(FraudRepository fraudRepository) {
    public boolean isFraudulentCustomer(Long customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
package com.khomsi.notification.service;

import com.khomsi.clients.notification.NotificationRequest;
import com.khomsi.notification.NotificationRepository;
import com.khomsi.notification.model.entity.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepo) {
    public void send(NotificationRequest request) {
        notificationRepo.save(
                Notification.builder()
                        .message(request.message())
                        .toCustomerId(request.toCustomerId())
                        .toCustomerEmail(request.toCustomerName())
                        .sentAt(LocalDateTime.now())
                        .sender("SEM")
                        .build()
        );
    }
}

package com.khomsi.clients.notification;

public record NotificationRequest(
        Long toCustomerId,
        String message,
        String toCustomerName) {
}

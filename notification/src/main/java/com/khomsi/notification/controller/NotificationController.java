package com.khomsi.notification.controller;

import com.khomsi.clients.notification.NotificationRequest;
import com.khomsi.notification.service.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Tag(name = "Notification Controller", description = "CRUD for Notification Controller")
public record NotificationController(NotificationService notificationService) {
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request) {
        notificationService.send(request);
    }
}

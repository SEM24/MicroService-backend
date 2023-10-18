package com.khomsi.notification.rabbitmq;

import com.khomsi.clients.notification.NotificationRequest;
import com.khomsi.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record NotificationConsumer(NotificationService notificationService) {
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest request) {
        log.info("Consumed {} from queue", request);
        notificationService.send(request);
    }
}

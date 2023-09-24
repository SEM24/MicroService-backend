package com.khomsi.notification;

import com.khomsi.notification.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

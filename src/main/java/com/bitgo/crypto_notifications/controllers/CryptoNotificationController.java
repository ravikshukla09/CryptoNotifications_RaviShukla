package com.bitgo.crypto_notifications.controllers;

import com.bitgo.crypto_notifications.models.Notification;
import com.bitgo.crypto_notifications.models.NotificationCreateRequest;
import com.bitgo.crypto_notifications.models.NotificationStatus;
import com.bitgo.crypto_notifications.models.SendNotificationRequest;
import com.bitgo.crypto_notifications.services.ICryptoNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crypto/notifications")
public class CryptoNotificationController {
    @Autowired
    private ICryptoNotification cryptoNotificationService;

    @PostMapping
    Notification createNotification(@RequestBody NotificationCreateRequest notificationCreateRequest) {
        return cryptoNotificationService.createNotification(notificationCreateRequest);
    }

    @PostMapping("/send")
    void sendNotification(@RequestBody SendNotificationRequest sendNotificationRequest) {
        cryptoNotificationService.sendNotification(sendNotificationRequest);
    }

    @GetMapping
    List<Notification> fetchNotifications(@RequestParam("status") Optional<NotificationStatus> notificationStatus) {
        return cryptoNotificationService.listNotifications(notificationStatus);
    }
}

package com.bitgo.crypto_notifications.services;

import com.bitgo.crypto_notifications.models.Notification;
import com.bitgo.crypto_notifications.models.NotificationCreateRequest;
import com.bitgo.crypto_notifications.models.NotificationStatus;
import com.bitgo.crypto_notifications.models.SendNotificationRequest;

import java.util.List;
import java.util.Optional;

public interface ICryptoNotification {
    Notification createNotification(NotificationCreateRequest notificationCreateRequest);
    void sendNotification(SendNotificationRequest sendNotificationRequest);
    List<Notification> listNotifications(Optional<NotificationStatus> notificationStatus);
}

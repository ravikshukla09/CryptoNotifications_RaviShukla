package com.bitgo.crypto_notifications.services;

import com.bitgo.crypto_notifications.db.CryptoNotificationDB;
import com.bitgo.crypto_notifications.models.Notification;
import com.bitgo.crypto_notifications.models.NotificationCreateRequest;
import com.bitgo.crypto_notifications.models.NotificationStatus;
import com.bitgo.crypto_notifications.models.SendNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptoNotificationService implements ICryptoNotification {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CryptoNotificationDB cryptoNotificationDB;

    @Override
    public Notification createNotification(NotificationCreateRequest notificationCreateRequest) {
        return cryptoNotificationDB.createNotification(notificationCreateRequest);
    }

    @Override
    public void sendNotification(SendNotificationRequest sendNotificationRequest) {
        Notification notification = cryptoNotificationDB.getNotificationById(sendNotificationRequest.getNotificationId());
        try {
            emailService.sendEmail(notification.toString(), sendNotificationRequest.getEmails());
            notification.setNotificationStatus(NotificationStatus.SENT);
        } catch (Exception ex) {
            notification.setNotificationStatus(NotificationStatus.FAILED);
            ex.printStackTrace();
        }
    }

    @Override
    public List<Notification> listNotifications(Optional<NotificationStatus> notificationStatus) {
        return cryptoNotificationDB.getNotifications(notificationStatus);
    }
}

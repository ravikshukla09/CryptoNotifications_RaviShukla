package com.bitgo.crypto_notifications.db;

import com.bitgo.crypto_notifications.exceptions.InvalidArgumentException;
import com.bitgo.crypto_notifications.models.Notification;
import com.bitgo.crypto_notifications.models.NotificationCreateRequest;
import com.bitgo.crypto_notifications.models.NotificationStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class CryptoNotificationDB {
    Map<Integer, Notification> notifications;
    AtomicInteger notificationId;

    public CryptoNotificationDB() {
        notifications = new ConcurrentHashMap<>();
        notificationId = new AtomicInteger();
    }

    public Notification createNotification(NotificationCreateRequest notificationCreateRequest) {
        Notification notification = new Notification(notificationId.incrementAndGet(), notificationCreateRequest);
        notifications.put(notification.getId(), notification);
        return notification;
    }

    public Notification getNotificationById(int id) {
        if (notifications.containsKey(id)) {
            return notifications.get(id);
        }
        throw new InvalidArgumentException("Notification with id: " + id + " not found");
    }

    public List<Notification> getNotifications(Optional<NotificationStatus> notificationStatus) {
        return notificationStatus.map(status -> notifications.values().stream().filter(notification -> notification.getNotificationStatus() == status).sorted().collect(Collectors.toList()))
                .orElseGet(() -> notifications.values().stream().sorted().collect(Collectors.toList()));
    }
}

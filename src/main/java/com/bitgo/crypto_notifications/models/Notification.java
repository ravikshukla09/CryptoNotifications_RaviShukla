package com.bitgo.crypto_notifications.models;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class Notification implements Comparable<Notification> {
    private final int id;
    private NotificationStatus notificationStatus;
    private final double bitcoinPrice;
    private final double dailyPercentChange;
    private final double tradingVolume;
    private final LocalDateTime createdAt;

    public Notification(int id, NotificationCreateRequest notificationCreateRequest) {
        this.id = id;
        bitcoinPrice = notificationCreateRequest.getBitcoinPrice();
        dailyPercentChange = notificationCreateRequest.getDailyPercentChange();
        tradingVolume = notificationCreateRequest.getTradingVolume();
        createdAt = LocalDateTime.now();
        notificationStatus = NotificationStatus.PENDING;
    }

    @Override
    public int compareTo(Notification o) {
        return o.createdAt.compareTo(this.createdAt);
    }

    public int getId() {
        return id;
    }

    public double getBitcoinPrice() {
        return bitcoinPrice;
    }

    public double getDailyPercentChange() {
        return dailyPercentChange;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}

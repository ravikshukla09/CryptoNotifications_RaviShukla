package com.bitgo.crypto_notifications.models;

import java.util.List;

public class SendNotificationRequest {
    int notificationId;
    List<String> emails;

    public int getNotificationId() {
        return notificationId;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}

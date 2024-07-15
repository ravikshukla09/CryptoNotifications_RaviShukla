package com.bitgo.crypto_notifications.services;

import java.util.List;

public interface EmailService {
    void sendEmail(String payload, List<String> emails);
}

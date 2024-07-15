package com.bitgo.crypto_notifications.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail(String payload, List<String> emails) {
        emails.parallelStream().forEach(email -> sendEmail(payload, email));
    }

    private void sendEmail(String payload, String email) {
        System.out.println("Sending email to " + email + " with payload: " + payload);
    }
}

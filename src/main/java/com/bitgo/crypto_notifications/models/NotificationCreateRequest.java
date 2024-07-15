package com.bitgo.crypto_notifications.models;

public class NotificationCreateRequest {
    private double bitcoinPrice;
    private double dailyPercentChange;
    private double tradingVolume;

    public NotificationCreateRequest(double bitcoinPrice, double dailyPercentChange, double tradingVolume) {
        this.bitcoinPrice = bitcoinPrice;
        this.dailyPercentChange = dailyPercentChange;
        this.tradingVolume = tradingVolume;
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
}

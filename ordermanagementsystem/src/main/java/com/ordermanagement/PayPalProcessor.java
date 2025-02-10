package com.ordermanagement;

public class PayPalProcessor implements IPaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("🅿️ Processing PayPal payment of $" + amount);
        return true;
    }
}
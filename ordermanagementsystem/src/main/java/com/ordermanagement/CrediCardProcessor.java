package com.ordermanagement;

public class CrediCardProcessor implements IPaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of Rs." + amount);
        return true;
    }
}

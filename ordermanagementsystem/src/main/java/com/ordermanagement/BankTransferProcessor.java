package com.ordermanagement;

public class BankTransferProcessor implements IPaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing bank transfer payment of" + amount);
        return true;
    }   

 

}
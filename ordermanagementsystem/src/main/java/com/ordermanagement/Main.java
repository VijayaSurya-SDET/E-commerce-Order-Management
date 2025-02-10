package com.ordermanagement;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("VijaySurya", "vijayasurya1810@gmail.com", "Arekere, Bangalore");

        Product p1 = new Product("HP Laptop", 99000, 10);
        Product p2 = new Product("MacBook Pro", 114000, 18);

        Order order = new Order(customer);
        order.addProduct(p1);
        order.addProduct(p2);

        InvoiceGenerator invoiceGen = new InvoiceGenerator();
        String invoice = invoiceGen.generateInvoice(order);

        System.out.println(invoice);


        OrderProcessor orderProcessor = new OrderProcessor(invoiceGen);
        IPaymentProcessor paymentProcessor;

        paymentProcessor = new BankTransferProcessor();
        orderProcessor.processOrder(order, paymentProcessor);

        paymentProcessor = new CrediCardProcessor();
        orderProcessor.processOrder(order, paymentProcessor);

        paymentProcessor = new PayPalProcessor();
        orderProcessor.processOrder(order, paymentProcessor);
    }
}

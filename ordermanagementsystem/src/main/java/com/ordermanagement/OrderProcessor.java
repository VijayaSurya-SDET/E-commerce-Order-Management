package com.ordermanagement;

public class OrderProcessor {

    private InvoiceGenerator invoiceGenerator;

    public OrderProcessor(InvoiceGenerator invoiceGenerator) {
        this.invoiceGenerator = invoiceGenerator;
    }

    // this is to check stock and process order
    public void processOrder(Order order, IPaymentProcessor paymentProcessor) {
        for (Product product : order.getProducts()) {
            if (product.getStock() <= 0) {
                System.out.println("Order cannot be processed: Out of stock - " + product.getDetails());
                return;
            }
        }

        // this is to Calculate total payment amount
        double paymentAmount = 0;
        for (Product product : order.getProducts()) {
            paymentAmount += product.getPrice();
        }

        // this method is to process payment
        boolean paymentSuccess = paymentProcessor.processPayment(paymentAmount);
        if (!paymentSuccess) {
            System.out.println(" Payment failed. Order not processed.");
            return;
        }

        // this method is to reduce stock after successful payment
        for (Product product : order.getProducts()) {
            product.reduceStock(1); // Assuming 1 quantity per product
        }

        // Finally to Generate and print invoice
        String invoice = invoiceGenerator.generateInvoice(order);
        System.out.println(invoice);
        System.out.println("Order processed successfully!");
    }
}

package com.ordermanagement;

public class InvoiceGenerator {

    public String generateInvoice (Order order){

String productsSummary = order.getOrderSummary();

double totalCost = 0;

        for (Product product : order.getProducts()) {
            totalCost += product.getPrice();  // Get price of each product
        }
        return productsSummary + "Total Cost: $" + totalCost;
    }

}

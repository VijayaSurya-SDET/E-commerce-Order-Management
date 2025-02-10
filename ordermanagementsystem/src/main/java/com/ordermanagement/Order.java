package com.ordermanagement;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Product> products;
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getDetails() + "Product added to the respective order");

    }

    public String getOrderSummary() {

        String summary = "Order Summary for " + customer.getContactInfo() + "\nProducts:\n";

        for (Product product : products) {
            summary += product.getDetails() + "\n";
        }
        return summary;
    }

    public List<Product> getProducts() {
        return products;
    }

}

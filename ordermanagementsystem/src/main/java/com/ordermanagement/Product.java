package com.ordermanagement;

public class Product implements IStockManager {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getDetails() {
        return "Product:" + name + ", price " + price + ", stock " + stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            System.out.println("Stocks are insufficient for " + name);
        } else {
            stock -= quantity;
            System.out.println(quantity + "Quantities sold - Remaining stock : " + stock);
        }
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    @Override
    public int checkStock() {
        return stock;
    }

    @Override
    public void updateStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock for " + name);
        }
    }

}

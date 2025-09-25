package com.project.services;

import com.project.models.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public void clearCart() {
        products.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println();
        for (Product product : products) {
            stringBuilder.append(product.toString()).append("\n");
        }

        stringBuilder.append("Загальна вартість: ").append(getTotalPrice());
        return stringBuilder.toString();
    }
}
package com.project.services;

import com.project.models.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> _products;

    public Cart() {
        _products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        _products.add(product);
    }

    public void removeProduct(Product product) {
        _products.remove(product);
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (Product product : _products) {
            total += product.get_price();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Product product : _products) {
            stringBuilder.append(product.toString()).append("\n");
            System.out.println();
        }

        stringBuilder.append("Загальна вартість: ").append(getTotalPrice());
        return stringBuilder.toString();
    }
}
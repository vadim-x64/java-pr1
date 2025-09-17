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

    public List<Product> getProducts() {
        return new ArrayList<>(_products);
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (Product product : _products) {
            total += product.get_price();
        }

        return total;
    }

    public void clearCart() {
        _products.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println();
        for (Product product : _products) {
            stringBuilder.append(product.toString()).append("\n");
        }

        stringBuilder.append("Загальна вартість: ").append(getTotalPrice());
        return stringBuilder.toString();
    }
}
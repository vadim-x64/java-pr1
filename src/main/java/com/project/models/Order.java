package com.project.models;

import com.project.services.Cart;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Order {
    private List<Product> products;
    private double totalPrice;
    private String status;

    public Order(Cart cart) {
        products = new ArrayList<>(cart.getProducts());
        totalPrice = cart.getTotalPrice();
        status = "Нове";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Замовлення:\n");

        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }

        sb.append("Загальна вартість: ").append(totalPrice).append("\n");
        sb.append("Статус: ").append(status);
        return sb.toString();
    }
}
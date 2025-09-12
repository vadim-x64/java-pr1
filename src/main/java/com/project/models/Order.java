package com.project.models;

import com.project.services.Cart;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Order {
    private List<Product> _products;
    private double _totalPrice;
    private String _status;

    public Order(Cart cart) {
        _products = new ArrayList<>(cart.getProducts());
        _totalPrice = cart.getTotalPrice();
        _status = "Нове";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Замовлення:\n");

        for (Product product : _products) {
            sb.append(product.toString()).append("\n");
        }

        sb.append("Загальна вартість: ").append(_totalPrice).append("\n");
        sb.append("Статус: ").append(_status);
        return sb.toString();
    }
}
package com.project;

import com.project.models.Product;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Ноутбук HP VICTUS", 27000.0, "Високопродуктивний ноутбук для роботи та ігор.");
        Product product2 = new Product(2, "Навушники JBL", 699.0, "Вкладиші з підключенням через USB-C.");
        Product product3 = new Product(3, "Смартфон POCO X6 PRO", 15999.0, "Функціональний телефон з купою різних функцій.");

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}
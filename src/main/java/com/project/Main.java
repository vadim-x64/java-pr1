package com.project;

import com.project.models.Product;
import com.project.models.Category;
import com.project.services.Cart;

public class Main {
    public static void main(String[] args) {
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук HP VICTUS", 27000.0, "Високопродуктивний ноутбук для роботи та ігор.", electronics);
        Product product2 = new Product(2, "Навушники JBL", 699.0, "Вкладиші з підключенням через USB-C.", accessories);
        Product product3 = new Product(3, "Смартфон POCO X6 PRO", 15999.0, "Функціональний телефон з купою різних функцій.", smartphones);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        Cart cart = new Cart();
        cart.addProduct(product1);

        System.out.println(cart);
    }
}
package com.project;

import com.project.models.Order;
import com.project.models.Product;
import com.project.models.Category;
import com.project.services.Cart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вітаємо в нашому магазині ShopOnline!");

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук HP VICTUS", 27000.0, "Високопродуктивний ноутбук для роботи та ігор.", electronics);
        Product product2 = new Product(2, "Навушники JBL", 699.0, "Вкладиші з підключенням через USB-C.", accessories);
        Product product3 = new Product(3, "Смартфон POCO X6 PRO", 15999.0, "Функціональний телефон з купою різних функцій.", smartphones);

        Cart cart = new Cart();

        while (true) {
            System.out.println();
            System.out.println("0. Вихід");
            System.out.println("1. Переглянути список товарів");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Зробити замовлення");
            System.out.println();
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println();
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                case 1:
                    System.out.println();
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Введіть ID товару для додавання до кошика: ");
                    int id = scanner.nextInt();

                    if (id == 1) {
                        cart.addProduct(product1);
                        System.out.println("Товар додано до кошика!");
                    } else if (id == 2) {
                        cart.addProduct(product2);
                        System.out.println("Товар додано до кошика!");
                    } else if (id == 3) {
                        cart.addProduct(product3);
                        System.out.println("Товар додано до кошика!");
                    } else {
                        System.out.println("Товар з таким ID не знайдено!");
                    }

                    break;
                case 3:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println();
                        System.out.println("Кошик порожній!");
                    } else {
                        System.out.println(cart);
                    }

                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println();
                        System.out.println("Додайте товари перед оформленням замовлення!");
                    } else {
                        Order order = new Order(cart);
                        System.out.println();
                        System.out.println("Замовлення оформлено!");
                        System.out.println(order);
                        cart.clear();
                    }

                    break;
                default:
                    System.out.println("Невідома опція! Спробуйте ще раз!");
                    break;
            }
        }
    }
}
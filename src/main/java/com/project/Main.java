package com.project;

import com.project.models.Order;
import com.project.models.Product;
import com.project.models.Category;
import com.project.services.Cart;
import com.project.services.FindItem;

import java.util.ArrayList;
import java.util.List;
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

        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);

        Cart cart = new Cart();
        FindItem findItem = new FindItem(allProducts);
        List<Order> orderHistory = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("0. Вихід");
            System.out.println("1. Переглянути список товарів");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Зробити замовлення");
            System.out.println("5. Очистити кошик");
            System.out.println("6. Переглянути замовлення");
            System.out.println("7. Пошук товарів");
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
                        orderHistory.add(order);
                        System.out.println();
                        System.out.println("Замовлення оформлено!");
                        System.out.println();
                        System.out.println(order);
                        cart.clearCart();
                    }

                    break;
                case 5:
                    if (!cart.getProducts().isEmpty()) {
                        cart.clearCart();
                        System.out.println();
                        System.out.println("Кошик було очищено!");
                    } else {
                        System.out.println();
                        System.out.println("Кошик порожній!");
                    }

                    break;
                case 6:
                    System.out.println();

                    if (orderHistory.isEmpty()) {
                        System.out.println("Історія замовлень порожня!");
                    } else {
                        System.out.println("Історія ваших замовлень");
                        System.out.println();

                        for (int i = 0; i < orderHistory.size(); i++) {
                            System.out.println("Замовлення #" + (i + 1));
                            for (Product product : orderHistory.get(i).get_products()) {
                                System.out.println(product.toString());
                            }
                            System.out.println("Загальна вартість: " + orderHistory.get(i).get_totalPrice());
                            System.out.println("Статус: " + orderHistory.get(i).get_status());
                            System.out.println("--------------------");
                        }
                    }

                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println();
                    System.out.print("Що шукаємо? ");
                    String searchTerm = scanner.nextLine();
                    List<Product> searchResults = findItem.search(searchTerm);

                    if (searchResults.isEmpty()) {
                        System.out.println();
                        System.out.println("За вашим запитом '" + searchTerm + "' товарів не знайдено!");
                    } else {
                        System.out.println("Результати пошуку за запитом '" + searchTerm + "':");
                        System.out.println();

                        for (Product product : searchResults) {
                            System.out.println(product);
                        }
                    }

                    break;
                default:
                    System.out.println("Невідома опція! Спробуйте ще раз!");
                    break;
            }
        }
    }
}
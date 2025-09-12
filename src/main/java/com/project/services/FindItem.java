package com.project.services;

import com.project.models.Product;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FindItem {
    private List<Product> products;

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        String searchTerm = name.toLowerCase().trim();

        for (Product product : products) {
            if (product.get_name().toLowerCase().contains(searchTerm)) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> searchByCategory(String categoryName) {
        List<Product> result = new ArrayList<>();
        String searchTerm = categoryName.toLowerCase().trim();

        for (Product product : products) {
            if (product.get_category().getName().toLowerCase().contains(searchTerm)) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> search(String searchTerm) {
        List<Product> result = new ArrayList<>();
        String term = searchTerm.toLowerCase().trim();

        for (Product product : products) {
            if (product.get_name().toLowerCase().contains(term) || product.get_category().getName().toLowerCase().contains(term)) {
                result.add(product);
            }
        }

        return result;
    }
}
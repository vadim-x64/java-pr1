package com.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int _id;
    private String _name;
    private double _price;
    private String _description;

    @Override
    public String toString() {
        return "Товар {" + "id = " + _id + ", назва = '" + _name + '\'' + ", ціна = " + _price +
                ", опис = '" + _description + '\'' + '}';
    }
}
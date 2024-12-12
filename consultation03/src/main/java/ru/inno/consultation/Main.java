package ru.inno.consultation;

import ru.inno.consultation.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1L, "Хлеб", 40L);
        Product product2 = new Product(2L, "Молоко", 65L);
        Product product3 = new Product(3L, "Сыр", 120L);
        Product product4 = new Product(4L, "Макароны", 57L);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        System.out.println(products);
    }
}
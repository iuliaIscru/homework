package com.inghubsromania.interview_homework.repository;

import com.inghubsromania.interview_homework.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Products {
    private static final Logger log = LoggerFactory.getLogger(Products.class);

    static {
        if (Products.all == null) {
            all = new HashMap<>();
        }
        Products.create("Product 1", 100.0);
        Products.create("Product 2", 100.0);
        Products.create("Product 3", 150.10);
    }

    public static Map<Long, Product> all;

    public static Optional<Product> one(long id) {
        log.info("Get product by id: {}", id);
        return Optional.ofNullable(all.get(id));
    }

    public static Product create(String name, double price) {
        long id = all.size() + 1;
        Product product = new Product(name, price);
        product.setId(id);
        all.put(id, product);
        return product;
    }

    public static Product changePrice(long id, double price) {
        log.info("Update product {}" + "price: {}", id, price);
        Product product = all.get(id);
        product.setPrice(price);
        return product;
    }
}

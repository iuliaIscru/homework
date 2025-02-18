package com.inghubsromania.interview_homework.repository;

import com.inghubsromania.interview_homework.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;

public class Products {
    private static final Logger log = LoggerFactory.getLogger(Products.class);
    public static Map<Long, Product> all = Map.ofEntries(
            Map.entry(1L, new Product(1L, "Product 1", 100.0)),
            Map.entry(2L, new Product(2L, "Product 2", 100.0)),
            Map.entry(3L, new Product(3L, "Product 3", 150.10))
    );

    public static Optional<Product> one(long id) {
        log.info("Get product by id: {}", id);
        return Optional.ofNullable(all.get(id));
    }
}

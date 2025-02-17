package com.inghubsromania.interview_homework.product;

import java.util.Map;

public class Products {
    public static Map<Long, Product> all = Map.ofEntries(
            Map.entry(1L, new Product(1L, "Product 1", 100.0)),
            Map.entry(2L, new Product(2L, "Product 2", 100.0)),
            Map.entry(3L, new Product(3L, "Product 3", 150.10))
    );

    public static Product one(long id) {

        return all.get(id);
    }
}

package com.inghubsromania.interview_homework.product;

import com.inghubsromania.interview_homework.entity.Product;
import com.inghubsromania.interview_homework.repository.Products;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductsTests {

    @Test
    public void shouldReturnTheProductHavingTheGivenId() {
        Optional<Product> product = Products.one(1L);
        product.ifPresent(p -> assertThat(p.getId()).isEqualTo(1L));
    }

    @Test
    public void shouldReturnTheProductHavingTheChangedPrice() {
        Product product = Products.all.get(1L);
        double price = product.getPrice();
        double newPrice = price + 0.5;
        Product productWithChangedPrice = Products.changePrice(product.getId(), newPrice);
        assertThat(productWithChangedPrice.getPrice()).isEqualTo(newPrice);
    }

    @Test
    public void shouldReturnTheCreatedProductHavingTheGivenNameAndPrice() {
        String name = "Product 4";
        double price = 200.0;
        Product product = Products.create(name, price);
        assertThat(Products.all.get(product.getId())).isEqualTo(product);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getPrice()).isEqualTo(price);
    }
}

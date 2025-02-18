package com.inghubsromania.interview_homework.controller.product;

import com.inghubsromania.interview_homework.entity.Product;
import com.inghubsromania.interview_homework.exception.ProductNotFoundException;
import com.inghubsromania.interview_homework.repository.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    @GetMapping("/{productId}")
    public Product one(@PathVariable long productId) {
        return Products.one(productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @GetMapping("/all")
    public List<Product> all() {
        return Products.all.values().stream().toList();
    }
}

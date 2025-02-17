package com.inghubsromania.interview_homework.product;

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
        return Products.one(productId);
    }

    @GetMapping("/all")
    public List<Product> all() {
        return Products.all.values().stream().toList();
    }
}

package com.inghubsromania.interview_homework.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {
    @GetMapping("/{productId}")
    public String getProduct(@PathVariable Long productId) {
        return "product: " + productId;
    }
}

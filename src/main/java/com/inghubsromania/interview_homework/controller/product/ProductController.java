package com.inghubsromania.interview_homework.controller.product;

import com.inghubsromania.interview_homework.entity.Product;
import com.inghubsromania.interview_homework.exception.ProductNotFoundException;
import com.inghubsromania.interview_homework.repository.Products;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@Secured("MANAGE_PRODUCT")
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

    @PostMapping
    public Product create(@RequestBody Product product) {
        return Products.create(product.getName(), product.getPrice());
    }

    @PutMapping("/{productId}")
    public Product changePrice(@RequestBody Product product, @PathVariable long productId) {
        return Products.changePrice(productId, product.getPrice());
    }
}

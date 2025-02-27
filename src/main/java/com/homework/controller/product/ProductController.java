package com.homework.controller.product;

import com.homework.entity.Product;
import com.homework.exception.ProductNotFoundException;
import com.homework.repository.Products;
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

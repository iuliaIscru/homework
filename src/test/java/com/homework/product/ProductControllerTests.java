package com.homework.product;

import com.homework.entity.Product;
import com.homework.exception.ProductNotFoundException;
import com.homework.repository.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnOneProductHavingTheGivenProductId() {
        long productId = 1L;
        String getProductUrl = "/product/" + productId;
        Product getProductResponseBody = Products.all.get(productId);
        ResponseEntity<Product> response = restTemplate.withBasicAuth("usr01", "test01").getForEntity(getProductUrl, Product.class);
        assertThat(response.getBody()).isEqualTo(getProductResponseBody);

    }

    @Test
    public void shouldThrowExceptionWhenProductNotFound() throws ProductNotFoundException {
        long productId = 10L;

        String getProductUrl = "/product/" + productId;
        ResponseEntity<String> response = restTemplate.withBasicAuth("usr01", "test01").getForEntity(getProductUrl, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isEqualTo(new ProductNotFoundException(productId).getMessage());
    }
}
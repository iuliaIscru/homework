package com.inghubsromania.interview_homework.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnStringContainingTheGivenProductId() {
        long productId = 1L;
        String getProductUrl = "/product/" + productId;
        String getProductResponseBody = "product: " + productId;
        ResponseEntity<String> response = restTemplate.getForEntity(getProductUrl, String.class);
        assertThat(response.getBody()).isEqualTo(getProductResponseBody);

    }
}
package com.homework.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void home() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("usr02", "test02").getForEntity("/home", String.class);
        assertThat(response.getBody()).isEqualTo("hello :)");
    }
}

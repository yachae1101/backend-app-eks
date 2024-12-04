package com.adamsoft.backend;

import com.adamsoft.backend.presentation.api.HealthApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HealthApiTest {

    @Test
    public void testHealthOk(){
        var api = new HealthApi();
        var health = api.getHealth();
        assertThat(health.getStatus()).isEqualTo("OK");
    }
}

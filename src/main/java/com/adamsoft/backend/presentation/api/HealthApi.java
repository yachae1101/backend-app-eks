package com.adamsoft.backend.presentation.api;

import com.adamsoft.backend.presentation.dto.HealthDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("health")
public class HealthApi {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(HealthApi.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthDto getHealth(){
        LOGGER.info("Health GET API Called");

        var health = new HealthDto();
        health.setStatus("OK");
        return health;
    }
}

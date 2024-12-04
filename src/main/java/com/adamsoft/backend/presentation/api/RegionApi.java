package com.adamsoft.backend.presentation.api;

import com.adamsoft.backend.domain.service.RegionService;
import com.adamsoft.backend.presentation.dto.RegionDto;
import com.adamsoft.backend.presentation.dto.RegionsDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegionApi {
    private final RegionService regionService;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(HealthApi.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionsDto getAllRegions(){
        LOGGER.info("getAllRegions");

        var allRegions = regionService.getAllRegions();
        var dtoList = new ArrayList<RegionDto>();
        allRegions.forEach(region -> {
            var dto = new RegionDto(region);
            dtoList.add(dto);
        });
        var regionsDto = new RegionsDto(dtoList);
        return regionsDto;
    }
}

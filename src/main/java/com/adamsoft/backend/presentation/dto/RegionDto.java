package com.adamsoft.backend.presentation.dto;

import com.adamsoft.backend.domain.model.Region;

public class RegionDto {
    private Integer regionId;
    private String regionName;

    public RegionDto(){}
    public RegionDto(Region region) {
        this.regionId = region.getRegionId();
        this.regionName = region.getRegionName();
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}

package com.adamsoft.backend.presentation.dto;

import java.util.ArrayList;
import java.util.List;

public class RegionsDto {

    private List<RegionDto> regionDtoList = new ArrayList<RegionDto>();

    public RegionsDto(){

    }

    public RegionsDto(List<RegionDto> regionDtoList) {
        this.regionDtoList = regionDtoList;
    }

    public List<RegionDto> getRegionDtoList() {
        return regionDtoList;
    }

    public void setRegionDtoList(List<RegionDto> regionDtoList) {
        this.regionDtoList = regionDtoList;
    }
}

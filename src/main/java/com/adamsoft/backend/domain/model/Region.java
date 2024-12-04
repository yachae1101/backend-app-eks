package com.adamsoft.backend.domain.model;

import com.adamsoft.backend.persistence.entity.RegionEntity;

import java.time.LocalDateTime;

public class Region {
    private Integer regionId;
    private String regionName;
    private LocalDateTime creationTimestamp;

    //각각의 항목을 받아서 인스턴스를 생성하는 메서드
    public Region(Integer regionId, String regionName, LocalDateTime creationTimestamp) {
        if(regionName == null){
            throw new IllegalArgumentException("regionName cannot b null");
        }
        this.regionId = regionId;
        this.regionName = regionName;
        this.creationTimestamp = creationTimestamp;
    }

    //Entity를 받아서 인스턴스를 생성하는 메서드
    public Region(RegionEntity regionEntity) {
        this(regionEntity.getRegionId(),
                regionEntity.getRegionName(),
                regionEntity.getCreationTimestamp());
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

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}

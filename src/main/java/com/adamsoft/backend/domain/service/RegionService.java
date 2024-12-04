package com.adamsoft.backend.domain.service;

import com.adamsoft.backend.domain.model.Region;

import java.util.List;

public interface RegionService {
    //매개변수 없이 전체 데이터를 가져오는 메서드
    public List<Region> getAllRegions();
}

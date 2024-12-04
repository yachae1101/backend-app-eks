package com.adamsoft.backend.persistence.repository;

import com.adamsoft.backend.persistence.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//RegionEntity 와 연결된 테이블에 CRUD 작업을 수행할 수 있는 기본 메서드를 구현한
//인스턴스를 자동으로 생성
@Repository
public interface RegionRepository extends JpaRepository<RegionEntity, Integer> {
    //기본적으로 추가되는 메서드
    //Entity를 매개변수로 받아서 삽입, 수정, 삭제하는 메서드
    //매개변수 없이 모든 데이터를 읽어오는 메서드
    //기본키를 매개변수로 받아서 하나의 데이터를 읽어오는 메서드

    //regionName을 가지고 데이터를 조회하는 메서드
    Optional<RegionEntity> findByRegionName(String regionName);
}

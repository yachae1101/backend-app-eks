package com.adamsoft.backend;

import com.adamsoft.backend.persistence.repository.RegionRepository;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.time.LocalDateTime;

import static com.ninja_squad.dbsetup.Operations.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//테스트 클래스라는 어노테이션
//이 클래스는 빌드를 할 때 테스트 용으로 사용이 되고 빌드 결과물을 만들 때 자동 소멸
@SpringBootTest
public class RegionRepositoryTest {
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Test
    @Tag("DBRequired")
    public void testFindAll(){
        prepareDatabase();

        //전체 데이터 가져오기 테스트: 개수가 맞는지 확인
        var result = regionRepository.findAll();
        assertThat(result).hasSize(4);
    }

    //테스트 메서드 호출할 때 마다
    @BeforeEach
    public void prepareDatabase(){
        var operations = sequenceOf(
                deleteAllFrom("region"),
                insertInto("region")
                        .columns("region_id", "region_name", "creation_timestamp")
                        .values(1, "지역1", LocalDateTime.now())
                        .values(2, "지역1", LocalDateTime.now())
                        .values(3, "지역1", LocalDateTime.now())
                        .values(4, "지역1", LocalDateTime.now())
                        .build()
        );
        var dbSetup = new DbSetup(new DataSourceDestination(dataSource),operations);
        dbSetup.launch();
    }
}

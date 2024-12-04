package com.adamsoft.backend;

import com.adamsoft.backend.domain.model.Region;
import com.adamsoft.backend.domain.service.RegionService;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;

@SpringBootTest
public class RegionServiceTest {
    @Autowired
    private RegionService regionService;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

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

    @Test
    @Tag("DBRequired")
    public void testServiceRegion(){
        List<Region> regionList = regionService.getAllRegions();
        Assertions.assertEquals(regionList.size(), 4);
    }
}

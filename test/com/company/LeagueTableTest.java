package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LeagueTableTest {

    @Test
    public void tableRanking() {
        var matches = Arrays.asList(
                new Match(TeamTest.LIONS.getName(), TeamTest.SNAKES.getName(),3,3),
                new Match(TeamTest.TARANTULAS.getName(), TeamTest.FC_AWESOME.getName(),1,0),
                new Match(TeamTest.LIONS.getName(), TeamTest.FC_AWESOME.getName(),1,1),
                new Match(TeamTest.TARANTULAS.getName(), TeamTest.SNAKES.getName(),3,1),
                new Match(TeamTest.LIONS.getName(), TeamTest.GROUCHES.getName(),4,0)
        );

       var leagueTable = new LeagueTable(matches);

       assertEquals(4,3);
        }
    }

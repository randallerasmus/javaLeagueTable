package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LeagueTableTest {

    private static final boolean OUTPUT_LEAGUE_TABLE_TO_SCREEN = true;

    @Test
    public void tableResults() {

        // SAMPLE INPUT
        var matches = Arrays.asList(
                new Match(TeamTest.LIONS.getName(), TeamTest.SNAKES.getName(),3,3),
                new Match(TeamTest.TARANTULAS.getName(), TeamTest.FC_AWESOME.getName(),1,0),
                new Match(TeamTest.LIONS.getName(), TeamTest.FC_AWESOME.getName(),1,1),
                new Match(TeamTest.TARANTULAS.getName(), TeamTest.SNAKES.getName(),3,1),
                new Match(TeamTest.LIONS.getName(), TeamTest.GROUCHES.getName(),4,0)
        );

        // EXPECTED SAMPLE OUTPUT
        var expectedLeagueTable = Arrays.asList(
                new LeagueEntry(
                        TeamTest.TARANTULAS.getName(),  2, 2, 0, 0, 6),
                new LeagueEntry(
                        TeamTest.LIONS.getName(), 3, 1, 2, 0, 5),
                new LeagueEntry(
                        TeamTest.FC_AWESOME.getName(),  2, 0, 1, 1, 1),
                new LeagueEntry(
                        TeamTest.SNAKES.getName(), 2, 0, 1, 1, 1),
                new LeagueEntry(
                        TeamTest.GROUCHES.getName(),  1, 0, 0, 1, 0)
        );

       var leagueTable = new LeagueTable(matches);

        var actualLeagueTable = leagueTable.getLeagueEntries();

        assertActualLeagueTableWithExpectedLeagueTable(expectedLeagueTable, actualLeagueTable);
        }

    private void assertActualLeagueTableWithExpectedLeagueTable(
            List<LeagueEntry> expectedLeagueTable, List<LeagueEntry> actualLeagueTable) {

        if (expectedLeagueTable.size() != actualLeagueTable.size()) {
            fail("The Expected League Table and The Actual League Table have different sizes");
        }

        if (OUTPUT_LEAGUE_TABLE_TO_SCREEN) {
            printTableResultOnConsole(actualLeagueTable);
        }

        for (var i = 0; i < expectedLeagueTable.size(); i++) {
            assertEquals(expectedLeagueTable.get(i).getTeamName(),actualLeagueTable.get(i).getTeamName());
            assertEquals(expectedLeagueTable.get(i).getPlayed(),actualLeagueTable.get(i).getPlayed());
            assertEquals(expectedLeagueTable.get(i).getWon(), actualLeagueTable.get(i).getWon());
            assertEquals(expectedLeagueTable.get(i).getDrawn(), actualLeagueTable.get(i).getDrawn());
            assertEquals(expectedLeagueTable.get(i).getLost(), actualLeagueTable.get(i).getLost());
            assertEquals(expectedLeagueTable.get(i).getPoints(),actualLeagueTable.get(i).getPoints());
            }
        }

    private void printTableResultOnConsole(List<LeagueEntry> tableEntries) {

        System.out.printf("%8s %-20s %9s %5s %7s %6s %8s\n",
                "Position", "\tClub", "Played", "Won", "Drawn", "Lost", "Points");
        for (var i = 0; i < tableEntries.size(); i++) {
            LeagueEntry tableEntry = tableEntries.get(i);

            System.out.printf("%-8d \t%-20s %6d %6d %6d %6d %6d\n",
                    (i + 1),
                    tableEntry.getTeamName(),
                    tableEntry.getPlayed(),
                    tableEntry.getWon(),
                    tableEntry.getDrawn(),
                    tableEntry.getLost(),
                    tableEntry.getPoints());
            }
        }
    }

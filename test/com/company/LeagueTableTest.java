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
                new Match(Teams.LIONS.getName(), Teams.SNAKES.getName(),3,3),
                new Match(Teams.TARANTULAS.getName(), Teams.FC_AWESOME.getName(),1,0),
                new Match(Teams.LIONS.getName(), Teams.FC_AWESOME.getName(),1,1),
                new Match(Teams.TARANTULAS.getName(), Teams.SNAKES.getName(),3,1),
                new Match(Teams.LIONS.getName(), Teams.GROUCHES.getName(),4,0)
        );

        // EXPECTED SAMPLE OUTPUT
        var expectedLeagueTable = Arrays.asList(
                new TeamEntry(
                        Teams.TARANTULAS.getName(),  2, 2, 0, 0, 6),
                new TeamEntry(
                        Teams.LIONS.getName(), 3, 1, 2, 0, 5),
                new TeamEntry(
                        Teams.FC_AWESOME.getName(),  2, 0, 1, 1, 1),
                new TeamEntry(
                        Teams.SNAKES.getName(), 2, 0, 1, 1, 1),
                new TeamEntry(
                        Teams.GROUCHES.getName(),  1, 0, 0, 1, 0)
        );

       var leagueTable = new LeagueTable(matches);

        var actualLeagueTable = leagueTable.getLeagueEntries();

        assertActualLeagueTableWithExpectedLeagueTable(expectedLeagueTable, actualLeagueTable);
        }

    private void assertActualLeagueTableWithExpectedLeagueTable(
            List<TeamEntry> expectedLeagueTable, List<TeamEntry> actualLeagueTable) {

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

    private void printTableResultOnConsole(List<TeamEntry> tableEntries) {

        System.out.printf("%8s %-20s %9s %5s %7s %6s %8s\n",
                "Position", "\tClub", "Played", "Won", "Drawn", "Lost", "Points");
        for (var i = 0; i < tableEntries.size(); i++) {
            TeamEntry tableEntry = tableEntries.get(i);

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

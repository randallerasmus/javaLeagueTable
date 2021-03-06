package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeagueTable {

    private final static int WIN_RESULT = 3;
    private final static int DRAW_RESULT = 1;


    private final List<Match> matches;

    public LeagueTable(List<Match> matches) {
        this.matches = matches;
    }

    private void computeMatchResult(Match match, TeamEntry homeTeam, TeamEntry awayTeam){
        if (match.getHomeScore() > match.getAwayScore()) {
            homeTeam.increaseWon();
            homeTeam.increasePoints(WIN_RESULT);
            awayTeam.increaseLost();
        } else if (match.getHomeScore() < match.getAwayScore()) {
            homeTeam.increaseLost();
            awayTeam.increaseWon();
            awayTeam.increasePoints(WIN_RESULT);
        } else {
            homeTeam.increaseDrawn();
            homeTeam.increasePoints(DRAW_RESULT);
            awayTeam.increaseDrawn();
            awayTeam.increasePoints(DRAW_RESULT);
        }
    }

    public List<TeamEntry> getLeagueEntries() {
        Map<String, TeamEntry> leagueTableEntries = new HashMap<>();

        matches.forEach(match -> {
            var homeTeam = getOrCreateMatches(leagueTableEntries, match.getHomeTeam());
            var awayTeam = getOrCreateMatches(leagueTableEntries, match.getAwayTeam());

            homeTeam.increasePlayed();
            awayTeam.increasePlayed();
            computeMatchResult(match, homeTeam, awayTeam);
        });

        return leagueTableEntries.values().stream()
                .sorted(Comparator.comparing(TeamEntry::getPoints).reversed()
                       .thenComparing(TeamEntry::getTeamName)).collect(Collectors.toList());
    }

    private TeamEntry getOrCreateMatches(Map<String, TeamEntry> leagueTableEntries, String teamName) {
        var leagueEntry = leagueTableEntries.get(teamName);
        if (leagueEntry != null) {
            return leagueEntry;
        }

        leagueTableEntries.put(teamName, new TeamEntry(teamName));
        return leagueTableEntries.get(teamName);
    }
}

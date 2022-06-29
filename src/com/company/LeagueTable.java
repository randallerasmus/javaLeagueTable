package com.company;

import java.util.List;

public class LeagueTable {

    private final static int WIN_RESULT = 3;
    private final static int DRAW_RESULT = 1;
    private final static int LOSS_RESULT = 0;

    private final List<Match> matches;

    public LeagueTable(List<Match> matches) {
        this.matches = matches;
    }

    private void countMatchResult(Match match, LeagueEntry homeTeam, LeagueEntry awayTeam){
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
}

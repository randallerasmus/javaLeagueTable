package com.company;

public class TeamEntry {

    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int points;

    public TeamEntry(final String teamName) {
        this.teamName = teamName;
    }

    public TeamEntry(String teamName, int played, int won, int drawn, int lost, int points) {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getPoints() {
        return points;
    }

    public void increaseWon() {
        this.won++;
    }

    public void increaseDrawn() {
        this.drawn++;
    }

    public void increaseLost() {
        this.lost++;
    }

    public void increasePoints(int points) {
        this.points += points;
    }

    public void increasePlayed() {
        this.played++;
    }
}

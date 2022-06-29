package com.company;

import java.util.Objects;

public class Team {

    private String teamName;
    private int score;
    private int draw;
    private int win;
    private int loss;
    private int result;

    public Team() {
    }

    public Team(String teamName, int score, int draw, int win, int loss, int result, int points) {
        this.teamName = teamName;
        this.score = score;
        this.draw = draw;
        this.win = win;
        this.loss = loss;
        this.result = result;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int points;


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", score=" + score +
                ", draw=" + draw +
                ", win=" + win +
                ", loss=" + loss +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return score == team.score && draw == team.draw && win == team.win && loss == team.loss && Objects.equals(teamName, team.teamName) && Objects.equals(result, team.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, score, draw, win, loss, result);
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {

        Team team1 = new Team();
        team1.setTeamName("Real Madrid");
        team1.setScore(10);


        Team team2 = new Team();
        team2.setTeamName("Barcelona");
        team2.setScore(6);


        if(team1.getScore() > team2.getScore()){
            team1.setPoints(3);
            System.out.println("Points for " + team1.toString());
        }else{
            team2.setPoints(3);
            System.out.println("Points for " + team2.toString());
        }


    }
}

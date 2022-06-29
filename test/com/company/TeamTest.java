package com.company;

public enum TeamTest {

    LIONS("Lions"),
    SNAKES("Snakes"),
    TARANTULAS("Tarantulas"),
    FC_AWESOME("FC Awesome"),
    GROUCHES("Grouches");

    private String name;

    TeamTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




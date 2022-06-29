package com.company;

public enum Teams {

    LIONS("Lions"),
    SNAKES("Snakes"),
    TARANTULAS("Tarantulas"),
    FC_AWESOME("FC Awesome"),
    GROUCHES("Grouches");

    private String name;

    Teams(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}




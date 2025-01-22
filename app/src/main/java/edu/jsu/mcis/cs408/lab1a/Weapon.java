package edu.jsu.mcis.cs408.lab1a;

public enum Weapon {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String description;

    Weapon (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


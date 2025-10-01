package ru.otus.basic.hw07;

public enum Terrain {

    PLAIN("равнина"),
    SWAMP("болото"),
    FOREST("густой лес");

    private String description;

    Terrain(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

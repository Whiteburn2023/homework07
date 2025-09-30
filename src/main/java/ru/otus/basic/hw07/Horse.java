package ru.otus.basic.hw07;

public class Horse implements Transport{
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain == Terrain.FOREST || terrain == Terrain.PLAIN;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (!canMove(terrain)){
            System.out.println(name + " не может ехать по " + terrain.getDescription());
            return false;
        }
        System.out.println(name + " едет по " + terrain.getDescription());
        return true;
    }
}

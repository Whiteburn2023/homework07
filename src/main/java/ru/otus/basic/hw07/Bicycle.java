package ru.otus.basic.hw07;

public class Bicycle implements Transport{
    private String name;

    public Bicycle(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain != Terrain.SWAMP;
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

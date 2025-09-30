package ru.otus.basic.hw07;

public class Rover implements Transport{
    private String name;
    private int fuelRover;          //объем бака в литрах

    public Rover(String name, int fuel) {
        this.name = name;
        this.fuelRover = fuel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return true;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        System.out.println(name + " едет по " + terrain.getDescription());
        return true;
    }
}

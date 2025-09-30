package ru.otus.basic.hw07;

public class Car implements Transport{
    private String name;
    private int fuelCar;        //объем бака в литрах

    public Car(String name, int fuel) {
        this.name = name;
        this.fuelCar = fuel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain == Terrain.PLAIN;
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

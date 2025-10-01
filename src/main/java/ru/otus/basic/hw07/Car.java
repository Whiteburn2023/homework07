package ru.otus.basic.hw07;

public class Car implements Transport{
    private final String name;
    private int fuelCar;        //объем бака в литрах
    private final int fullFuel;

    public Car(String name, int fuelCar, int fullFuel) {
        this.name = name;
        this.fullFuel = fullFuel;
        this.fuelCar = Math.min(fuelCar, fullFuel);
    }

    @Override
    public String getTypeCurrentTransport() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain == Terrain.PLAIN;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (distance < 0){
            System.out.println("дистанция не может быть меньше 0");
            return false;
        }
        if (!canMove(terrain)){
            System.out.println(name + " не может ехать по " + terrain.getDescription());
            return false;
        }

        int fuelNeeded = distance * 1;          //магическое число, 1 л = 1км
        if (fuelCar >= fuelNeeded){
            fuelCar -= fuelNeeded;
            System.out.println("fuelCar " + fuelCar + " fuelNeeded " + fuelNeeded);
            System.out.println(name + " едет по " + terrain.getDescription() + " и расходует единиц топлива " + fuelNeeded + " в баке осталось " + (fuelCar));
            return true;
        } else if (fuelNeeded > fullFuel) {
            System.out.println("у "+ name +" недостаточно топлива для преодоления данной дистанции");
            return false;
        } else {
            System.out.println("не хватает топлива, нужно дозаправить еще " + (fuelNeeded - fuelCar));
            return false;
        }
    }
    @Override
    public void refuel(int amount){
        if ((amount + fuelCar) > fullFuel){
            this.fuelCar = fullFuel;
            System.out.println("заправлен полный бак");
        } else {
            fuelCar += amount;
            System.out.println(name + " дозаправлен на " + amount+ " литров. До полного еще нужно " + (fullFuel - fuelCar) + " литров.");
        }
    }



}

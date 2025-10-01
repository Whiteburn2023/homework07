package ru.otus.basic.hw07;

public class Rover implements Transport{
    private final String name;
    private int fuelRover;      //объем бака в литрах
    private final int fullFuel;

    public Rover(String name, int fuelRover, int fullFuel) {
        this.name = name;
        this.fullFuel = fullFuel;
        this.fuelRover = Math.min(fuelRover, fullFuel);
    }

    @Override
    public String getTypeCurrentTransport() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return true;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (distance < 0){
            System.out.println("дистанция не может быть меньше 0");
            return false;
        }

        int fuelNeeded = distance * 1;          //магическое число, 1 л = 1км
        if (fuelRover >= fuelNeeded){
            fuelRover -= fuelNeeded;
            System.out.println("fuelCar " + fuelRover + " fuelNeeded " + fuelNeeded);
            System.out.println(name + " едет по " + terrain.getDescription() + " и расходует единиц топлива " + fuelNeeded + " в баке осталось " + (fuelRover));
            return true;
        } else if (fuelNeeded > fullFuel) {
            System.out.println("у "+ name +" недостаточно топлива для преодоления данной дистанции");
            return false;
        } else {
            System.out.println("не хватает топлива, нужно дозаправить еще " + (fuelNeeded - fuelRover));
            return false;
        }
    }

    @Override
    public void refuel(int amount) {
        if ((amount + fuelRover) > fullFuel){
            this.fuelRover = fullFuel;
            System.out.println("заправлен полный бак");
        } else {
            fuelRover += amount;
            System.out.println(name + " дозаправлен на " + amount+ " литров. До полного еще нужно " + (fullFuel - fuelRover) + " литров.");
        }
    }
}

package ru.otus.basic.hw07;

public class Bicycle implements Transport{
    private final String name;
    private int riderStamina;
    private final int fullRiderStamina;

    public Bicycle(String name, int riderStamina, int fullRiderStamina) {
        this.name = name;
        this.fullRiderStamina = fullRiderStamina;
        this.riderStamina = Math.min(this.riderStamina, fullRiderStamina);
    }

    @Override
    public String getTypeCurrentTransport() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain != Terrain.SWAMP;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (distance < 0){
            System.out.println("дистанция не может быть меньше 0");
            return false;
        }
        int fuelNeeded = distance * 1;          //магическое число, 1 сила = 1км
        if (riderStamina >= fuelNeeded){
            riderStamina -= fuelNeeded;
            System.out.println("riderStamina " + riderStamina + " fuelNeeded " + fuelNeeded);
            System.out.println(name + " едет по " + terrain.getDescription() + " и расходует единиц сил " + fuelNeeded + " сил осталось " + (riderStamina));
            return true;
        } else if (fuelNeeded > riderStamina) {
            System.out.println("у "+ name + " недостаточно сил для преодоления данной дистанции");
            return false;
        } else {
            System.out.println(name + "не хватает сил, нужно отдохнуть еще " + (fuelNeeded - riderStamina));
            return false;
        }
    }

    @Override
    public void refuel(int amount) {
        if ((amount + riderStamina) > fullRiderStamina){
            this.riderStamina = fullRiderStamina;
            System.out.println(name + " отдохнул(а) и полна сил");
        } else {
            riderStamina += amount;
            System.out.println(name + " отдохнул(а) на " + amount+ " сил. До полного восстановления сил еще нужно " + (fullRiderStamina - riderStamina) + " сил.");
        }
    }



}

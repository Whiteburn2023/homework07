package ru.otus.basic.hw07;

public class Horse implements Transport{
    private final String name;
    private int stamina;
    private final int fullStamina;

    public Horse(String name, int stamina, int fullStamina) {
        this.name = name;
        this.fullStamina = fullStamina;
        this.stamina = Math.min(stamina, fullStamina);
    }

    @Override
    public String getTypeCurrentTransport() {
        return name;
    }

    @Override
    public boolean canMove(Terrain terrain) {
        return terrain == Terrain.FOREST || terrain == Terrain.PLAIN;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (distance < 0){
            System.out.println("дистанция не может быть меньше 0");
            return false;
        }
        int fuelNeeded = distance * 1;          //магическое число, 1 сила = 1км
        if (stamina >= fuelNeeded){
            stamina -= fuelNeeded;
            System.out.println("stamina " + stamina + " fuelNeeded " + fuelNeeded);
            System.out.println(name + " едет по " + terrain.getDescription() + " и расходует единиц сил " + fuelNeeded + " сил осталось " + (stamina));
            return true;
        } else if (fuelNeeded > stamina) {
            System.out.println("у "+ name + " недостаточно сил для преодоления данной дистанции");
            return false;
        } else {
            System.out.println(name + "не хватает сил, нужно отдохнуть еще " + (fuelNeeded - stamina));
            return false;
        }
    }

    @Override
    public void refuel(int amount) {
        if ((amount + stamina) > fullStamina){
            this.stamina = fullStamina;
            System.out.println(name + " отдохнул(а) и полна сил");
        } else {
            stamina += amount;
            System.out.println(name + " отдохнул(а) на " + amount+ " сил. До полного восстановления сил еще нужно " + (fullStamina - stamina) + " сил.");
        }
    }



}

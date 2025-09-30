package ru.otus.basic.hw07;

public class MyAppDrive {
    public static void main(String[] args) {
        Human human = new Human("Санчо");

        Transport car = new Car("легковой автомобиль", 50);
        Transport horse = new Horse("лошадка");
        Transport bicycle = new Bicycle("лисопед");
        Transport rover = new Rover("вездеход", 120);


        human.mountTransport(rover);
        human.move(8,Terrain.SWAMP);
        human.move(7,Terrain.FOREST);
        human.move(6,Terrain.PLAIN);
        human.mountTransport(horse);
        human.dismountTransport();
        human.dismountTransport();


    }
}

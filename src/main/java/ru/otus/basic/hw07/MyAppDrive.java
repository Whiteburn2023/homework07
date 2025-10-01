package ru.otus.basic.hw07;

public class MyAppDrive {
    public static void main(String[] args) {
        Human human = new Human("Санчо");

        Transport car = new Car("легковой автомобиль", 50, 80);
        Transport horse = new Horse("лошадка", 80, 80);
        Transport bicycle = new Bicycle("лисопед", 60, 60);
        Transport rover = new Rover("вездеход", 130, 120);

//        human.mountTransport(rover);
//        human.dismountTransport();
        human.mountTransport(bicycle);
        human.dismountTransport();
//        human.move(80,Terrain.SWAMP);
//        human.move(7,Terrain.FOREST);
        human.move(600,Terrain.PLAIN);
        human.move(70,Terrain.PLAIN);
        human.move(30,Terrain.PLAIN);
        bicycle.refuel(60);
        human.move(10,Terrain.PLAIN);
        bicycle.refuel(60);
        human.move(20,Terrain.PLAIN);
        human.dismountTransport();
        human.mountTransport(bicycle);
        human.move(10,Terrain.PLAIN);
//        human.mountTransport(bicycle);
//        human.move(8,Terrain.SWAMP);
//        human.move(7,Terrain.FOREST);
//        human.move(6,Terrain.PLAIN);

    }
}

package ru.otus.basic.hw07;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public String getName() {
        return name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void mountTransport(Transport transport) {
        if (this.currentTransport != null) {
            System.out.println(name + " уже управляет " + currentTransport.getTypeCurrentTransport());
            return;
        }
        this.currentTransport = transport;
        System.out.println(name + " управляет " + transport.getTypeCurrentTransport());
    }

    public void dismountTransport(){
        if (this.currentTransport == null){
            System.out.println(name + " и так уже пешком");
            return;
        }
        System.out.println(name + " больше не управляет " + currentTransport.getTypeCurrentTransport());
        this.currentTransport = null;
    }

    public boolean move(int distance, Terrain terrain){
        if (distance < 0){
            System.out.println("дистанция не может быть меньше 0");
            return false;
        }
        System.out.println(name + " пытается переместиться на " + distance + " км по " + terrain.getDescription());

        if (currentTransport != null) {
            boolean success = currentTransport.move(distance, terrain);
            if (success) {
                System.out.println(name + " успешно едет на " + currentTransport.getTypeCurrentTransport());
            } else {
                System.out.println(name + " не может ехать на " + currentTransport.getTypeCurrentTransport());
            }
            return success;
        } else {
            System.out.println(name + " прошел пешком " + distance + " км по " + terrain.getDescription());
            return true;
        }
    }
}

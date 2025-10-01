package ru.otus.basic.hw07;

public interface Transport {
    String getTypeCurrentTransport();
    boolean canMove(Terrain terrain);
    boolean move(int distance, Terrain terrain);

    void refuel(int amount);


}

package ru.otus.basic.hw07;

public interface Transport {
    String getName();
    boolean canMove(Terrain terrain);
    boolean move(int distance, Terrain terrain);

}

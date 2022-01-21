package ru.korepin.tanks.gameObjects;

public class Tank extends GameObject {

    public Tank(int startX, int startY, int[][] image) {
        super(startX, startY, image);
    }

    public Tank(int startX, int startY, int[][] image, boolean isBarrier) {
        super(startX, startY, image, isBarrier);
    }
}

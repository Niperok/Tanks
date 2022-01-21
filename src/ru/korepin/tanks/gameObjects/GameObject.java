package ru.korepin.tanks.gameObjects;

import java.awt.*;

public class GameObject {
    public static final int SIZE = 80;
    protected int startX;
    protected int startY;
    protected boolean isBarrier;
    protected int[][] image;

    public GameObject(int startX, int startY, int[][] image) {
        this.startX = startX;
        this.startY = startY;
        this.image = image;
    }

    public GameObject(int startX, int startY, int[][] image, boolean isBarrier) {
        this(startX, startY, image);
        this.isBarrier = isBarrier;
    }

    public void paintGameObject(Graphics g, int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                g.setColor(new Color(image[y][x], true));
                g.fillRect(startX + x, startY + y, 1, 1);
            }
        }
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public boolean isBarrier() {
        return isBarrier;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }
}

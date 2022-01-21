package ru.korepin.tanks.gameObjects;

import java.util.HashMap;
import java.util.Map;

public class Sprite extends GameObject {
    public static final Map<String, int[][]> SPRITES = new HashMap<>();
    public static final int SIZE = 40;

    public Sprite(int startX, int startY, int[][] image) {
        super(startX, startY, image);
    }

    public Sprite(int startX, int startY, int[][] image, boolean isBarrier) {
        super(startX, startY, image, isBarrier);
    }
}

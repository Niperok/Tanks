package ru.korepin.tanks.gameObjects;

import ru.korepin.tanks.render.Parser;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Block extends GameObject {

    public static final Map<String, int[][]> OBJECTS = new HashMap<>();
    private final Sprite[][] block = new Sprite[2][2];

    public Block(int startX, int startY, int[][] pattern) {
        super(startX, startY, new int[SIZE][SIZE]);
        createBlock(pattern);
    }

    public Block(int startX, int startY, int[][] pattern, boolean isBarrier) {
        super(startX, startY, new int[SIZE][SIZE], isBarrier);
        createBlock(pattern);
    }

    private void createBlock(int[][] pattern) {
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                block[y][x] = new Sprite(startX + (x * 40), startY + (y * 40), Sprite.SPRITES.get(getSpriteName(pattern[y][x])), pattern[y][x] != 0);
            }
        }
    }

    public void paintBlock(Graphics g) {
        for (Sprite[] line : block) {
            for (Sprite sprite : line) {
                sprite.paintGameObject(g, Parser.SPRITE_SIZE);
            }
        }
    }

    private String getSpriteName(int id) {
        switch (id) {
            case 1:
                return "Brick.png";
            default:
                return "Black.png";
        }
    }

    public Sprite[][] getBlock() {
        return block;
    }
}

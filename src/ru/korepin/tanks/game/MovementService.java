package ru.korepin.tanks.game;

import ru.korepin.tanks.Application;
import ru.korepin.tanks.gameObjects.Block;
import ru.korepin.tanks.gameObjects.GameObject;
import ru.korepin.tanks.gameObjects.Player;
import ru.korepin.tanks.gameObjects.Sprite;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementService {
    private static boolean leftPressed;
    private static boolean upPressed;
    private static boolean rightPressed;
    private static boolean downPressed;


    public static void init() {
        Application.getJFrame().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37 -> leftPressed = true;
                    case 38 -> upPressed = true;
                    case 39 -> rightPressed = true;
                    case 40 -> downPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 37 -> leftPressed = false;
                    case 38 -> upPressed = false;
                    case 39 -> rightPressed = false;
                    case 40 -> downPressed = false;
                }
            }
        });
    }

    public <T extends GameObject> T move(T gameObject) {
        if (gameObject instanceof Player) {
            return movePlayer(gameObject);
        }
        return gameObject;
    }

    private <T extends GameObject> T movePlayer(T gameObject) {
        int newStartX = gameObject.getStartX();
        int newStartY = gameObject.getStartY();
        int step = 10;
        if (upPressed) {
            Application.getRenderService().toTheTop(gameObject);
            newStartY -= step;
            if (!checkUpCollision(newStartX, newStartY)) {
                gameObject.setStartY(newStartY);
            }
        }
        if (downPressed) {
            Application.getRenderService().toTheDown(gameObject);
            newStartY += step;
            if (!checkDownCollision(newStartX, newStartY)) {
                gameObject.setStartY(newStartY);
            }
        }
        if (leftPressed) {
            Application.getRenderService().toTheLeft(gameObject);
            newStartX -= step;
            if (!checkLeftCollision(newStartX, newStartY)) {
                gameObject.setStartX(newStartX);
            }
        }
        if (rightPressed) {
            Application.getRenderService().toTheRight(gameObject);
            newStartX += step;
            if (!checkRightCollision(newStartX, newStartY)) {
                gameObject.setStartX(newStartX);
            }
        }
        return gameObject;
    }

    private boolean checkCollision(int x, int y) {
        return Application.getScreen().checkCollision(x, y);
    }

    private boolean checkUpCollision(int x, int y) {
        return checkCollision(x + 1, y) ||
                checkCollision(x + Sprite.SIZE, y) ||
                checkCollision(x + Block.SIZE - 1, y);
    }

    private boolean checkDownCollision(int x, int y) {
        return checkCollision(x + 1, y + Block.SIZE - 1) ||
                checkCollision(x + Sprite.SIZE, y + Block.SIZE - 1) ||
                checkCollision(x + Block.SIZE - 1, y + Block.SIZE - 1);
    }

    private boolean checkLeftCollision(int x, int y) {
        return checkCollision(x, y + 1) ||
                checkCollision(x, y + Sprite.SIZE) ||
                checkCollision(x, y + Block.SIZE - 1);
    }

    private boolean checkRightCollision(int x, int y) {
        return checkCollision(x + Block.SIZE - 1, y + 1) ||
                checkCollision(x + Block.SIZE - 1, y + Sprite.SIZE) ||
                checkCollision(x + Block.SIZE - 1, y + Block.SIZE - 1);
    }
}

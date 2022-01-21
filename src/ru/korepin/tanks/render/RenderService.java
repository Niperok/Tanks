package ru.korepin.tanks.render;

import ru.korepin.tanks.Application;
import ru.korepin.tanks.gameObjects.Block;
import ru.korepin.tanks.gameObjects.GameObject;

import javax.swing.*;
import java.awt.*;

public class RenderService {
    public Screen init(JFrame jFrame) {
        Parser.parseSprites("/home/asp-ksv/IdeaProjects/Tanks/src/ru/korepin/tanks/img");
        Parser.parseObjects("/home/asp-ksv/IdeaProjects/Tanks/src/ru/korepin/tanks/img/objects");
        jFrame.setMinimumSize(new Dimension(1040, 1080));
        jFrame.setLocation(0, 0);
        jFrame.setVisible(true);
        return render(new Screen());
    }

    public Screen render(Screen screen) {
        Application.getJFrame().getContentPane().removeAll();
        Application.getJFrame().getContentPane().add(screen);
        Application.getJFrame().repaint();
        return screen;
    }

    public GameObject toTheLeft(GameObject gameObject) {
        gameObject.setImage(rotateLeft(getObjectDefaultImage(gameObject)));
        return gameObject;
    }

    public GameObject toTheRight(GameObject gameObject) {
        gameObject.setImage(rotateRight(getObjectDefaultImage(gameObject)));
        return gameObject;
    }

    public GameObject toTheTop(GameObject gameObject) {
        gameObject.setImage(getObjectDefaultImage(gameObject));
        return gameObject;
    }

    public GameObject toTheDown(GameObject gameObject) {
        gameObject.setImage(rotateDown(getObjectDefaultImage(gameObject)));
        return gameObject;
    }

    private int[][] rotateLeft(int[][] image) {
        int[][] newObjectImage = new int[image.length][image[0].length];
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                newObjectImage[image[y].length - x - 1][y] = image[y][x];
            }
        }
        return newObjectImage;
    }

    private int[][] rotateRight(int[][] image) {
        int[][] newObjectImage = new int[image.length][image[0].length];
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                newObjectImage[x][image.length - y - 1] = image[y][x];
            }
        }
        return newObjectImage;
    }

    private int[][] rotateDown(int[][] image) {
        int[][] newObjectImage = new int[image.length][image[0].length];
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                newObjectImage[image.length - y - 1][image[y].length - x - 1] = image[y][x];
            }
        }
        return newObjectImage;
    }

    private int[][] getObjectDefaultImage(GameObject gameObject) {
        return Block.OBJECTS.get("Tank0000.png");
    }
}

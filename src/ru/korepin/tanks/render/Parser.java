package ru.korepin.tanks.render;

import ru.korepin.tanks.gameObjects.Block;
import ru.korepin.tanks.gameObjects.Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Parser {
    public static final int SPRITE_SIZE = 40;
    public static final int OBJECT_SIZE = 80;

    public static int[][] getSprite(String pathname) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(pathname));
            int[][] pixels = new int[SPRITE_SIZE][SPRITE_SIZE];
            for (int y = 0; y < SPRITE_SIZE; y++) {
                for (int x = 0; x < SPRITE_SIZE; x++) {
                    pixels[y][x] = bufferedImage.getRGB(x, y);
                }
            }
            return pixels;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[SPRITE_SIZE][SPRITE_SIZE];
    }

    private static int[][] getObject(String pathname) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(pathname));
            int[][] pixels = new int[OBJECT_SIZE][OBJECT_SIZE];
            for (int y = 0; y < OBJECT_SIZE; y++) {
                for (int x = 0; x < OBJECT_SIZE; x++) {
                    pixels[y][x] = bufferedImage.getRGB(x, y);
                }
            }
            return pixels;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[OBJECT_SIZE][OBJECT_SIZE];
    }

    public static void parseSprites(String pathname) {
        Path path = Path.of(pathname);
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            files.forEach(s -> {
                        if (Files.isRegularFile(s)) {
                            Sprite.SPRITES.put(s.getFileName().toString(), getSprite(s.toString()));
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseObjects(String pathname) {
        Path path = Path.of(pathname);
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            files.forEach(s -> {
                        Block.OBJECTS.put(s.getFileName().toString(), getObject(s.toString()));
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

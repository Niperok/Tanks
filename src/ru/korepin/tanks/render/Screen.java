package ru.korepin.tanks.render;

import ru.korepin.tanks.game.MovementService;
import ru.korepin.tanks.gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JPanel {
    private static final int WIDTH = 13;
    private static final int HEIGHT = 13;

    private static final MovementService movementService = new MovementService();

    private final ArrayList<GameObject> objects = new ArrayList<>();

    private static final int[][][][] MAP =
            {
                    {
                            {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}},
                            {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}
                    },
                    {
                            {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}},
                            {{1, 1}, {1, 1}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}},
                            {{0, 0}, {0, 0}}, {{1, 1}, {0, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 1}},
                            {{0, 0}, {1, 1}}, {{0, 0}, {1, 0}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}, {{1, 1}, {1, 1}}, {{0, 0}, {0, 0}}
                    },
                    {
                            {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 1}, {0, 1}},
                            {{0, 0}, {0, 0}}, {{1, 0}, {1, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}, {{0, 0}, {0, 0}}
                    },
            };

    private final Block[][] field = new Block[HEIGHT][WIDTH];

    public Screen() {
        createField();
        addObjects();
    }

    public void removeObjects() {
        objects.clear();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Block[] line : field) {
            for (Block block : line) {
                block.paintBlock(g);
            }
        }
        for (GameObject gameObject : objects) {
            gameObject.paintGameObject(g, Parser.OBJECT_SIZE);
        }
    }

    public void moveObjects() {
        objects.forEach(movementService::move);
    }

    public void addObject(GameObject gameObject) {
        objects.add(gameObject);
    }

    public void addObjects() {
        objects.add(new Tank(320, 320, Block.OBJECTS.get("Tank0000.png"), true));
    }

    public boolean checkCollision(int x, int y) {
        return isOutOfField(x, y) ||
                isOnBarrier(x, y) ||
                objects.stream().filter(o -> !(o instanceof Player))
                        .anyMatch(o -> x >= o.getStartX() && x < o.getStartX() + 80 &&
                                y >= o.getStartY() && y <= o.getStartY() + 80);
    }

    private boolean isOutOfField(int x, int y) {
        return x < 0 || x >= 1040 || y < 0 || y >= 1040;
    }

    private boolean isOnBarrier(int x, int y) {
        int blockX = Math.min(x / Block.SIZE, 12);
        int blockY = Math.min(y / Block.SIZE, 12);
        Sprite[][] block = field[blockY][blockX].getBlock();
        int spriteX = Math.min((x % Block.SIZE) / Sprite.SIZE, 1);
        int spriteY = Math.min((y % Block.SIZE) / 40, 1);
        return block[spriteY][spriteX].isBarrier();
    }

    private void createField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                field[y][x] = new Block(x * 80, y * 80, MAP[y][x]);
            }
        }
    }
}

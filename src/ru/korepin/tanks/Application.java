package ru.korepin.tanks;

import ru.korepin.tanks.game.MovementService;
import ru.korepin.tanks.gameObjects.Block;
import ru.korepin.tanks.gameObjects.Player;
import ru.korepin.tanks.render.RenderService;
import ru.korepin.tanks.render.Screen;

import javax.swing.*;
import java.util.Date;

public class Application extends JPanel {

    private static final JFrame J_FRAME = new JFrame("Tanks");
    private static final RenderService renderService = new RenderService();

    private static Screen screen;

    public static void main(String[] args) {
        Application application = new Application();
        MovementService.init();
        screen = renderService.init(J_FRAME);
        application.runApplication(new Date());
    }

    private void runApplication(Date nextTick) {
        Player player = new Player(80, 960, Block.OBJECTS.get("Tank0000.png"));
        screen.addObject(player);
        while (true) {
            if (nextTick.before(new Date())) {
                nextTick.setTime(nextTick.getTime() + 100);
                screen.moveObjects();
                renderService.render(screen);
            }
        }
    }

    public static JFrame getJFrame() {
        return J_FRAME;
    }

    public static Screen getScreen() {
        return screen;
    }

    public static RenderService getRenderService() {
        return renderService;
    }
}

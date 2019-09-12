package tank.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import static tank.main.consts.Constants.*;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class TankGame {
    
    private static GameState gamestate = new GameState();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank……↑↓-选择……回车-开始……玩家一：WSAD-上下左右……J-开火……P-暂停……玩家二：↑↓←→-上下左右……\\-开火");
        TankGame game = new TankGame();
        gamestate.setBackground(Color.BLACK);
        frame.add(gamestate);
        String iconUrl = "src" + File.separator + "tank" + File.separator + "main" + File.separator + "gameresource" + File.separator + "images" + File.separator + "enemy3U.gif";
        frame.setIconImage(new ImageIcon(iconUrl).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        // 窗口置中
        frame.setLocationRelativeTo(null);
        
        frame.addKeyListener(gamestate.getListener());
        
        frame.setVisible(true);

        frame.setResizable(false);
        
        game.action();
    }

    /**
     * 定时器
     */
    private void action() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 10ms走一次
                gamestate.gameState();
            }
        }, INTERVAL, INTERVAL);
    }
    
}

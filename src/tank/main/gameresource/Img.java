package tank.main.gameresource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Img {

    public static BufferedImage title;
    public static BufferedImage options;
    public static BufferedImage selectTank;
    public static BufferedImage gameOver;
    public static BufferedImage steel;
    public static BufferedImage steels;
    public static BufferedImage wall;
    public static BufferedImage walls;
    public static BufferedImage river;
    public static BufferedImage grass;
    public static BufferedImage home;

    public static BufferedImage[] blasts = new BufferedImage[7];
    public static BufferedImage[] blasts1 = new BufferedImage[8];
    public static BufferedImage[] borns = new BufferedImage[4];
    public static BufferedImage[] awards = new BufferedImage[3];
    
    public static BufferedImage[] heroBullets = new BufferedImage[4];
    public static BufferedImage[] enemyBullets = new BufferedImage[4];
    
    public static BufferedImage[] sHero1 = new BufferedImage[4];
    
    public static BufferedImage[] lHero1 = new BufferedImage[4];
    
    public static BufferedImage[] sHero2 = new BufferedImage[4];
    
    public static BufferedImage[] lHero2 = new BufferedImage[4];
    
    public static BufferedImage[] sEnemys = new BufferedImage[4];
    
    public static BufferedImage[] mEnemys = new BufferedImage[4];
    
    public static BufferedImage[] lEnemys = new BufferedImage[4]; 
    

    
    /*
     * 用静态代码块初始化图片资源
     */
    static {
        try {
            title = getBufferedImage("title.gif");
            options = getBufferedImage("select.gif");
            selectTank = getBufferedImage("selecttank.gif");
            gameOver = getBufferedImage("over.gif");
            steel = getBufferedImage("steel.gif");
            steels = getBufferedImage("steels.gif");
            wall = getBufferedImage("wall.gif");
            walls = getBufferedImage("walls.gif");
            river = getBufferedImage("river.gif");
            grass = getBufferedImage("grass.png");
            home = getBufferedImage("home.png");

            for (int i = 0; i <= blasts.length / 2; i++) {
                blasts[i] = getBufferedImage("blast" + (i + 1) + ".gif");
            }
            for (int i = blasts.length / 2 + 1; i < blasts.length; i++) {
                blasts[i] = getBufferedImage("blast" + (blasts.length - i) + ".gif");
            }
            
            for (int i = 0; i < blasts1.length; i++) {
                blasts1[i] = getBufferedImage("blast" + (i + 1) + ".gif");
            }
            
            for (int i = 0; i < borns.length; i++) {
                borns[i] = getBufferedImage("born" + (i + 1) + ".gif");
            }
            
            awards[0] = getBufferedImage("blood.gif");
            awards[1] = getBufferedImage("star.gif");
            awards[2] = getBufferedImage("bomb.gif");
            
            heroBullets[0] = getBufferedImage("heroBulletU.png");
            heroBullets[1] = getBufferedImage("heroBulletD.png");
            heroBullets[2] = getBufferedImage("heroBulletL.png");
            heroBullets[3] = getBufferedImage("heroBulletR.png");
            enemyBullets[0] = getBufferedImage("ebulletU.png");
            enemyBullets[1] = getBufferedImage("ebulletD.png");
            enemyBullets[2] = getBufferedImage("ebulletL.png");
            enemyBullets[3] = getBufferedImage("ebulletR.png");
            
            sHero1[0] = getBufferedImage("p1tankU.gif");
            sHero1[1] = getBufferedImage("p1tankD.gif");
            sHero1[2] = getBufferedImage("p1tankL.gif");
            sHero1[3] = getBufferedImage("p1tankR.gif");
            
            lHero1[0] = getBufferedImage("p1bigtankU.png");
            lHero1[1] = getBufferedImage("p1bigtankD.png");
            lHero1[2] = getBufferedImage("p1bigtankL.png");
            lHero1[3] = getBufferedImage("p1bigtankR.png");
            
            sHero2[0] = getBufferedImage("p2tankU.gif");
            sHero2[1] = getBufferedImage("p2tankD.gif");
            sHero2[2] = getBufferedImage("p2tankL.gif");
            sHero2[3] = getBufferedImage("p2tankR.gif");
            
            lHero2[0] = getBufferedImage("p2bigtankU.png");
            lHero2[1] = getBufferedImage("p2bigtankD.png");
            lHero2[2] = getBufferedImage("p2bigtankL.png");
            lHero2[3] = getBufferedImage("p2bigtankR.png");
            
            sEnemys[0] = getBufferedImage("enemy1U.gif");
            sEnemys[1] = getBufferedImage("enemy1D.gif");
            sEnemys[2] = getBufferedImage("enemy1L.gif");
            sEnemys[3] = getBufferedImage("enemy1R.gif");
            
            mEnemys[0] = getBufferedImage("enemy2U.gif");
            mEnemys[1] = getBufferedImage("enemy2D.gif");
            mEnemys[2] = getBufferedImage("enemy2L.gif");
            mEnemys[3] = getBufferedImage("enemy2R.gif");
            
            lEnemys[0] = getBufferedImage("enemy3U.gif");
            lEnemys[1] = getBufferedImage("enemy3D.gif");
            lEnemys[2] = getBufferedImage("enemy3L.gif");
            lEnemys[3] = getBufferedImage("enemy3R.gif");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getBufferedImage(String imageName) {
        try {
            return ImageIO.read(Img.class.getResource("images" + File.separator + imageName));
        } catch (Exception e) {
            System.out.println(imageName + "图片资源读取失败！");
            e.printStackTrace();
        }
        return null;
    }
    
}



















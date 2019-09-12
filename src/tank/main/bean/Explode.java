package tank.main.bean;

import java.awt.image.BufferedImage;

import tank.main.gameresource.Img;
import tank.map.Home;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Explode {

    private BufferedImage[] images;
    private BufferedImage image;
    private int index;
    private int i;
    private int x;
    private int y;
    
    /**
     * 子弹射击坦克的构造方法
     */
    public Explode(BaseTank tank) {
        this.images = Img.blasts;
        image = images[0];
        // 因为爆炸图片比坦克图片大了，所以要减一下，让爆炸图片置中
        this.x = tank.getX() - 38;
        this.y = tank.getY() - 24;
    }
    
    /**
     * 子弹射击边界爆炸的构造方法
     */
    public Explode(Bullet b) {
        this.images = Img.blasts;
        image = images[0];
        // 因为爆炸图片比子弹图片大了，所以要减一下
        this.x = b.getX() - 58;
        this.y = b.getY() - 44;
    }
    
    /**
     * 子弹射击家爆炸的构造方法
     */
    public Explode(Home home) {
        this.images = Img.blasts1;
        image = images[0];
        // 因为爆炸图片比家图片大了，所以要减一下
        this.x = home.getX() - 38;
        this.y = home.getY() - 24;
    }
    
    /**
     * 检测爆炸是否结束的方法
     * 10ms走一次
     */
    public boolean blastDone() {
        i++;
        int interval = 20;
        // 则interval*10 ms换一张图片，形成动态效果
        if (i >= interval) {
            i = 0;
            if (index == images.length) {
                return true;
            }
            image = images[index++];
        }
        return false;
    }
    
    public BufferedImage[] getImages() {
        return images;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}

package tank.main.bean;

import java.awt.image.BufferedImage;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Bullet {

    private static final int U = 0;
    private static final int D = 1;
    private static final int L = 2;
    private static final int R = 3;
    
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    
    private int speed;
    private int direction;

    Bullet(BufferedImage image) {
        this.image = image;
    }

    Bullet(int x, int y, int direction, int bulletSpeed, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.speed = bulletSpeed;
        this.direction = direction;
    }

    /**
     * 子弹移动方法
     */
    public void step() {
        switch (direction) {
            case U:
                y -= speed;
                break;
            case D:
                y += speed;
                break;
            case L:
                x -= speed;
                break;
            case R:
                x += speed;
                break;
                default: break;
        }
    }
       
    /**
     * 子弹越界检查
     */
    public boolean outOfBounds(BaseTank tank) {
        /*
         * 英雄坦克和敌方坦克子弹越界边界点稍微不一样
         * 英雄坦克子弹越界点稍微靠里，为了让爆炸效果可见
         */
        if (tank instanceof HeroTank) {
            return x < 0 || y < 0
                    ||
                   x > WIDTH - this.width || y > HEIGHT - 2 * this.height;
        }
        return x < -this.width || y < -this.height
                ||
               x > WIDTH || y > HEIGHT;
    }
    
    /**
     * 判断子弹碰撞到子弹的方法
     */
    public boolean isHit(Bullet b) {
        return b.getX() + b.getWidth() > this.x && b.getX() < this.x + this.width
                &&
                b.getY() + b.getHeight() > this.y && b.getY() < this.y + this.height;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }
    
}

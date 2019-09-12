package tank.map;

import java.awt.image.BufferedImage;

import tank.main.bean.Bullet;
import tank.main.bean.BaseTank;
import tank.main.bean.HeroTank;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public abstract class BaseBuilding {

    protected int x;
    protected int y;
    protected BufferedImage image;
    protected int width;
    protected int height;

    public boolean isHit(Bullet b) {
        return b.getX() + b.getWidth() > this.x && b.getX() < this.x + this.width
                &&
                b.getY() + b.getHeight() > this.y && b.getY() < this.y + this.height;
    }

    public boolean isKnocked(BaseTank tank) {
        return tank.getX() + tank.getWidth() > this.x && tank.getX() < this.x + this.width
                &&
                tank.getY() + tank.getHeight() > this.y && tank.getY() < this.y + this.height;
    }

    public boolean isKnocked(HeroTank tank) {
        // 为什么减，因为画出的坦克比坦克图片要小
        return tank.getX() + tank.getWidth() - 3 > this.x && tank.getX() + 3 < this.x + this.width
                &&
                tank.getY() + tank.getHeight() - 3 > this.y && tank.getY() + 3 < this.y + this.height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}














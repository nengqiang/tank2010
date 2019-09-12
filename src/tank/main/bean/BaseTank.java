package tank.main.bean;

import java.awt.image.BufferedImage;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public abstract class BaseTank {

    protected static final int U = 0;
    protected static final int D = 1;
    protected static final int L = 2;
    protected static final int R = 3;

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;
    protected BufferedImage[] images;
    protected int blood;
    protected int fire;
    protected int speed;
    protected BufferedImage[] explode;
    
    protected int oldX, oldY;

    /**
     * 坦克移动方法
     */
    public abstract void step();
    
    /**
     * 判断坦克是否被击中的方法
     */
    public boolean isHit(Bullet b) {
        return b.getX() + b.getWidth() > this.x
                && b.getX() < this.x + this.width
                && b.getY() + b.getHeight() > this.y
                && b.getY() < this.y + this.height;
    }
    
    /**
     * 判断坦克是否被坦克碰撞到的方法
     */
    public boolean isKnocked(BaseTank b) {
        return b.getX() + b.getWidth() > this.x
                && b.getX() < this.x + this.width
                && b.getY() + b.getHeight() > this.y
                && b.getY() < this.y + this.height;
    }
    
    /**
     * 撞到墙后回到撞墙之前的坐标
     */
    public void returnToOldPoint() {
        this.x = oldX;
        this.y = oldY;
    }

    public void addBlood(int n) {
        this.blood += n;
    }

    public void minusBlood(int n) {
        this.blood -= n;
    }

    public void addFire(int n) {
        this.fire += n;
    }

    public void minusFire(int n) {
        this.fire -= n;
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

    public BufferedImage[] getImages() {
        return images;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }
}

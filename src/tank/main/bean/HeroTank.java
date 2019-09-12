package tank.main.bean;

import tank.main.gameresource.Img;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class HeroTank extends BaseTank {

    private boolean isUp, isDown, isLeft, isRight;
    private int lifeNum;
    
    public HeroTank() {}

    public HeroTank(int xLong, int yLong, int blood, int fire, BufferedImage[] images) {
        this.images = images;
        this.image = images[0];
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = (WIDTH - this.width) / 2 - xLong;
        this.y = HEIGHT - this.height - yLong;
        this.oldX = x;
        this.oldY = y;
        this.blood = blood;
        this.fire = fire;
        this.speed = 2;
        this.lifeNum = 1;
    }

    @Override
    public void step() {
        // heroTank的移动由玩家控制
    }
    
    /**
     * 英雄坦克生成子弹的方法
     */
    public List<Bullet> shoot() {
        /*不同类型坦克对应不同的子弹速度，将该值传入到step()方法中去*/
        int bulletSpeed = 0;
        if (this.images == Img.sHero1 || this.images == Img.sHero2) {
            bulletSpeed = 5;
        } else if (this.images == Img.lHero1 || this.images == Img.lHero2) {
            bulletSpeed = 7;
        }
        
        List<Bullet> bs = new ArrayList<>();
        /*该对象仅用于辅助作用，不对它进行任何操作*/
        //x y direction speed image
        Bullet bulletUp = new Bullet(Img.heroBullets[U]);
        Bullet bulletLeft = new Bullet(Img.heroBullets[L]);
        /*将不同方向子弹图片传入new出来的子弹对象*/
        BufferedImage heroBulletUp = Img.heroBullets[U];
        BufferedImage heroBulletDown = Img.heroBullets[D];
        BufferedImage heroBulletLeft = Img.heroBullets[L];
        BufferedImage heroBulletRight = Img.heroBullets[R];
        /*英雄坦克朝向不同方向 对应 子弹不同的初始位置 和 前进方向*/
        if (image == images[U]) {
            bs.add(new Bullet(x + (this.width - bulletUp.getWidth()) / 2,
                    y - bulletUp.getHeight(), U, bulletSpeed, heroBulletUp));
        } else if (image == images[D]) {
            bs.add(new Bullet(x + (this.width - bulletUp.getWidth()) / 2,
                    y + this.height + bulletUp.getHeight(), D, bulletSpeed, heroBulletDown));
        } else if (image == images[L]) {
            bs.add(new Bullet(x - bulletLeft.getWidth(),
                    y + (this.height - bulletLeft.getHeight()) / 2, L, bulletSpeed, heroBulletLeft));
        } else if (image == images[R]) {
            bs.add(new Bullet(x + this.width,
                    y + (this.height - bulletLeft.getHeight()) / 2, R, bulletSpeed, heroBulletRight));
        }
        return bs;
    }
    
    /**
     * 英雄坦克运动方法
     * 根据运动方向选择坦克图片
     * 10ms走一次
     */
    public void move() {
        this.oldX = x;
        this.oldY = y;
        //如果向上 而且 在边界内 ，就向上移动
        if (isUp && y > 0) {
            // 这个声音不仅难听， 而且大量消耗线程个数，故不要
            // MusicPlay.moveMusic();
            this.image = images[U];
            this.y -= speed;
        } else if (isDown && y < (HEIGHT - this.height - 40)) {
            // MusicPlay.moveMusic();
            this.image = images[D];
            this.y += speed;
        } else if (isLeft && x > 0) {
            // MusicPlay.moveMusic();
            this.image = images[L];
            this.x -= speed;
        } else if (isRight && x < (WIDTH - this.width - 20)) {
            // MusicPlay.moveMusic();
            this.image = images[R];
            this.x += speed;
        }
    }

    public void setPosition(int xLong, int yLong) {
        this.x = (WIDTH - this.width) / 2 - xLong;
        this.y = HEIGHT - this.height - yLong;
    }

    public void addLifeNum(int n) {
        this.lifeNum += n;
    }

    public void minusLifeNum(int n) {
        this.lifeNum -= n;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public void setImages(BufferedImage[] images) {
        this.images = images;
    }

    public int getLifeNum() {
        return this.lifeNum;
    }

    public void setLifeNum(int num) {
        this.lifeNum = num;
    }

}





package tank.main.bean;

import tank.main.gameresource.Img;

import java.awt.image.BufferedImage;

import static tank.main.consts.Constants.*;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class EnemyTank extends BaseTank {

    public EnemyTank() {}

    public EnemyTank(BufferedImage [] images) {
        this.images = images;
    }
    
    public EnemyTank(int x, int y, int life, int speed, BufferedImage[] images) {
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
        this.images = images;
        this.image = images[0];
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.blood = life;
        this.speed = speed;
        explode = Img.blasts;
    }

    private int count = 0;
    private int direction = 1;

    /**
     * 敌方坦克的移动方法
     * 10ms走一次
     */
    @Override
    public void step() {
        // 1.5s换一次方向
        count++;
        int idx = 1500 / INTERVAL;
        if (count >= idx) {
            count = 0;
            // 产生随机方向
            direction = RAND.nextInt(4);
        }
        // 根据方向选择坦克图片和移动方向
        move(direction);
    }

    private void move(int direction) {
        oldX = x;
        oldY = y;
        // 根据方向选择坦克图片和移动方向
        switch (direction) {
            case U: 
                this.image = images[U];
                moveUp();
                break;
            case D:
                this.image = images[D];
                moveDown();
                break;
            case L:
                this.image = images[L];
                moveLeft();
                break;
            case R:
                this.image = images[R];
                moveRight();
                break;
                default: break;
        }
    }
    
    private void moveUp() {
        y -= speed;
        checkBump();
    }

    private void moveDown() {
        y += speed;
        checkBump();
    }

    private void moveLeft() {
        x -= speed;
        checkBump();
    }

    private void moveRight() {
        x += speed;
        checkBump();
    }
    
    /**
     * 碰撞检测
     */
    private void checkBump() {
        // 撞到边界
        if (y < 0) {
            moveDown();
        }
        // 微调
        int fineTuning1 = 40;
        if (y > HEIGHT - this.height - fineTuning1) {
            moveUp();
        }
        if (x < 0 ) {
            moveRight();
        }
        int fineTuning2 = 18;
        if (x > WIDTH - this.width - fineTuning2) {
            moveLeft();
        }
    }

    public Bullet shoot() {
        // 不同类型坦克对应不同的子弹速度，将该值传入到step()方法中去
        int bulletSpeed = 0;
        if (this.images == Img.sEnemys) {
            bulletSpeed = 5;
        } else if (this.images == Img.mEnemys) {
            bulletSpeed = 6;
        } else if (this.images == Img.lEnemys) {
            bulletSpeed = 9;
        }
        // 该对象仅用于辅助作用，不对它进行任何操作
        //x y direction speed image
        Bullet bUp = new Bullet(0, 0, 1, 0, Img.enemyBullets[U]);
        Bullet bLeft = new Bullet(0, 0, 1, 0, Img.enemyBullets[L]);
        /*将不同方向子弹图片传入new出来的子弹对象*/
        BufferedImage enUp = Img.enemyBullets[U];
        BufferedImage enDown = Img.enemyBullets[D];
        BufferedImage enLeft = Img.enemyBullets[L];
        BufferedImage enRight = Img.enemyBullets[R];
        switch (direction) {
            case U:
                return new Bullet(x + (this.width - bUp.getWidth()) / 2, y - bUp.getHeight(), U, bulletSpeed, enUp);
            case D:
                return new Bullet(x + (this.width - bUp.getWidth()) / 2, y + this.height + bUp.getHeight(), D, bulletSpeed, enDown);
            case L:
                return new Bullet(x - bLeft.getWidth(), y + (this.height - bLeft.getHeight()) / 2, L, bulletSpeed, enLeft);
            case R:
                return new Bullet(x + this.width, y + (this.height - bLeft.getHeight()) / 2, R, bulletSpeed, enRight);
                default: return null;
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImages(BufferedImage[] images) {
        this.images = images;
    }

}











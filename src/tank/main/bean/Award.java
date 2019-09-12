package tank.main.bean;

import tank.main.gameresource.Img;

import java.awt.image.BufferedImage;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Award {

    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private int awardIndex;
    
    public Award(int x, int y, int awardIndex) {
        this.x = x + 10;
        this.y = y + 10;
        this.image = Img.awards[awardIndex];
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.awardIndex = awardIndex;
    }
    
    public boolean isEaten(HeroTank heroTank) {
        return heroTank.getX() + heroTank.getWidth() > this.x
                && heroTank.getX() < this.x + this.width
                && heroTank.getY() + heroTank.getHeight() > this.y
                && heroTank.getY() < this.y + this.height;
    }
    
    /**
     * 返回奖励类型
     * 0-加血加火力 1-变身加命 2-敌方全炸
     */
    public int getAwardType(){
        return awardIndex;
    }
    
    /**
     * 获取坐标及图片paint方法里会用到
     */
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
}

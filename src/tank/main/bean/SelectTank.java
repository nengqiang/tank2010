package tank.main.bean;

import tank.main.gameresource.Img;

import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class SelectTank extends BaseTank {

    private boolean upCase, downCase;
    private boolean isTwoPlayers;

    public SelectTank() {
        this.image = Img.selectTank;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = (WIDTH - width) / 2 - (Img.options.getWidth() + width) / 2;
        this.y = 445;
    }

    private int index = 1;

    /**
     * 这个方法用来控制选择坦克的移动
     */
    @Override
    public void step() {
        if (upCase) {
            if (index > 1) {
                index--;
            } else {
                index = 3;
            }
            select(index);
        } else if (downCase) {
            if (index < 3) {
                index++;
            } else {
                index = 1;
            }
            select(index);
        }
        isTwoPlayers = index == 2;
    }
    
    /**
     * 这个方法确定选项坦克的y坐标
     */
    private void select(int index) {
        switch (index) {
            case 1: this.y = 445; break;
            case 2: this.y = 510; break;
            case 3: this.y = 575; break;
            default: break;
        }
    }

    public void setUpCase(boolean upCase) {
        this.upCase = upCase;
    }

    public void setDownCase(boolean downCase) {
        this.downCase = downCase;
    }

    public boolean isTwoPlayers() {
        return isTwoPlayers;
    }

}

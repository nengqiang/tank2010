package tank.map;

import tank.main.gameresource.Img;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Wall extends BaseBuilding {
    
    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Img.wall;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }
    
}

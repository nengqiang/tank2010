package tank.map;

import tank.main.gameresource.Img;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class River extends BaseBuilding {

    public River(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Img.river;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }
    
}

package tank.map;

import tank.main.gameresource.Img;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Steel extends BaseBuilding {

    public Steel(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Img.steel;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }
    
}

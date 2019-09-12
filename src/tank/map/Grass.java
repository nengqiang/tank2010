package tank.map;

import tank.main.gameresource.Img;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Grass extends BaseBuilding {

    public Grass(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = Img.grass;
        this.width = image.getWidth();
        this.height = image.getHeight();  
    }
    
}

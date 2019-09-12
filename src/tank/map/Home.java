package tank.map;

import tank.main.gameresource.Img;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Home extends BaseBuilding {

    public Home() {
        this.image = Img.home;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = (WIDTH - this.width) / 2;
        this.y = (HEIGHT - this.height) - 40;
    }
    
}

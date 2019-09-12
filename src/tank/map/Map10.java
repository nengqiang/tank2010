package tank.map;

import java.util.List;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Map10 {

    private int x = WIDTH;
    private int y = HEIGHT;

    /**这是家（home）的x,y坐标*/
    private int basicX = (x - 60) / 2;
    private int basicY = (y - 60) - 40;

    public Map10(List<BaseBuilding> walls, List<BaseBuilding> steels, List<BaseBuilding> grass, List<BaseBuilding> river) {
        /*这是围住家（home）的墙*/
        //左边第一列
        walls.add(new Wall(basicX - 60, basicY + 30));
        walls.add(new Wall(basicX - 60, basicY));
        walls.add(new Wall(basicX - 60, basicY - 30));
        walls.add(new Wall(basicX - 60, basicY - 60));
        //左边第二列
        walls.add(new Wall(basicX - 30, basicY + 30));
        walls.add(new Wall(basicX - 30, basicY));
        walls.add(new Wall(basicX - 30, basicY - 30));
        walls.add(new Wall(basicX - 30, basicY - 60));
        //右边第一列（从左往右）
        walls.add(new Wall(basicX + 60, basicY + 30));
        walls.add(new Wall(basicX + 60, basicY));
        walls.add(new Wall(basicX + 60, basicY - 30));
        walls.add(new Wall(basicX + 60, basicY - 60));
        //右边第二列
        walls.add(new Wall(basicX + 90, basicY + 30));
        walls.add(new Wall(basicX + 90, basicY));
        walls.add(new Wall(basicX + 90, basicY - 30));
        walls.add(new Wall(basicX + 90, basicY - 60));
        //上方的墙
        walls.add(new Wall(basicX, basicY - 30));
        walls.add(new Wall(basicX, basicY - 60));
        walls.add(new Wall(basicX + 30, basicY - 30));
        walls.add(new Wall(basicX + 30, basicY - 60));
        /************护城池end********/
        
        //全屏地图
        for (int i = 0; i < x ; i += 30) {
            for (int j = 120; j < basicY - 90; j += 30) {
                walls.add(new Wall(i, j));
            }
        }
        
    }
    
}

package tank.map;

import java.util.List;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Map2 {

    private int x = WIDTH;
    private int y = HEIGHT;

    /**这是家（home）的x,y坐标*/
    private int basicX = (x - 60) / 2;
    private int basicY = (y - 60) - 40;

    public Map2(List<BaseBuilding> walls, List<BaseBuilding> steels, List<BaseBuilding> grass, List<BaseBuilding> rivers) {
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
        
        
        /*中间下面的地图*/
        for (int i = 150; i <= 420; i += 30) {
            walls.add(new Wall(basicX - 180, basicY - i));
            walls.add(new Wall(basicX - 150, basicY - i));
            walls.add(new Wall(basicX - 120, basicY - i));
            walls.add(new Wall(basicX - 90, basicY - i));
            walls.add(new Wall(basicX + 210, basicY - i));
            walls.add(new Wall(basicX + 180, basicY - i));
            walls.add(new Wall(basicX + 150, basicY - i));
            walls.add(new Wall(basicX + 120, basicY - i));
        }
        for (int i = 150; i <= 300; i += 30) {
            walls.add(new Wall(basicX - 60, basicY - i));
            walls.add(new Wall(basicX - 30, basicY - i));
            walls.add(new Wall(basicX, basicY - i));
            walls.add(new Wall(basicX + 30, basicY - i));
            walls.add(new Wall(basicX + 60, basicY - i));
            walls.add(new Wall(basicX + 90, basicY - i));
        }
        
        /*左边下面的地图*/
        //左边第二列
        walls.add(new Wall(basicX - 270, basicY + 30));
        walls.add(new Wall(basicX - 270, basicY));
        walls.add(new Wall(basicX - 300, basicY + 30));
        walls.add(new Wall(basicX - 300, basicY));
        for (int i = 120; i <= 300; i += 30) {
            walls.add(new Wall(basicX - 270, basicY - i));
            walls.add(new Wall(basicX - 300, basicY - i));
        }
        for (int i = 330; i < 450; i += 30) {
            steels.add(new Steel(basicX - 270, basicY - i));
            steels.add(new Steel(basicX - 300, basicY - i));
        }
        //左边第一列
        for (int i = basicY + 30; i >= 420; i -= 30) {
            walls.add(new Wall(90, i));
            walls.add(new Wall(120, i));
        }
        steels.add(new Steel(0, 440));
        steels.add(new Steel(30, 440));
        steels.add(new Steel(60, 440));
        steels.add(new Steel(0, 470));
        steels.add(new Steel(30, 470));
        steels.add(new Steel(60, 470));
        //第二列上面向左
        for (int i = 90; i <= basicX - 270; i += 30) {
            walls.add(new Wall(i, basicY - 450));
            walls.add(new Wall(i, basicY - 480));
        }
        walls.add(new Wall(basicX - 270, basicY - 450));
        walls.add(new Wall(basicX - 270, basicY - 480));
        //第二列上面向右
        for (int i = basicX - 240; i <= basicX + 60; i += 60) {
            grass.add(new Grass(i, basicY - 480));
        }
        grass.add(new Grass(basicX - 240, basicY - 420));
        steels.add(new Steel(basicX + 210, basicY - 450));
        steels.add(new Steel(basicX + 180, basicY - 450));
        steels.add(new Steel(basicX + 150, basicY - 450));
        steels.add(new Steel(basicX + 120, basicY - 450));
        steels.add(new Steel(basicX + 210, basicY - 480));
        steels.add(new Steel(basicX + 180, basicY - 480));
        steels.add(new Steel(basicX + 150, basicY - 480));
        steels.add(new Steel(basicX + 120, basicY - 480));
        
        /*左边上面的地图*/
        for (int i = 0; i <= 180; i += 60) {
            grass.add(new Grass(i, basicY - 540));
        }
        
        walls.add(new Wall(basicX - 180, basicY - 540));
        walls.add(new Wall(basicX - 150, basicY - 540));
        walls.add(new Wall(basicX - 120, basicY - 540));
        walls.add(new Wall(basicX - 90, basicY - 540));
        walls.add(new Wall(basicX - 180, basicY - 510));
        walls.add(new Wall(basicX - 150, basicY - 510));
        walls.add(new Wall(basicX - 120, basicY - 510));
        walls.add(new Wall(basicX - 90, basicY - 510));
        
        steels.add(new Steel(basicX, basicY - 540));
        steels.add(new Steel(basicX + 30, basicY - 540));
        steels.add(new Steel(basicX, basicY - 510));
        steels.add(new Steel(basicX + 30, basicY - 510));
        steels.add(new Steel(basicX - 60, basicY - 600));
        steels.add(new Steel(basicX - 30, basicY - 600));
        steels.add(new Steel(basicX - 60, basicY - 570));
        steels.add(new Steel(basicX - 30, basicY - 570));
        
        //左边第一列
        for (int i = 60; i <= 180; i += 30) {
            walls.add(new Wall(60, i));
            walls.add(new Wall(90, i));
        }
        
        //左边第二列
        for (int i = 0; i <= 90; i += 30) {
            steels.add(new Steel(basicX - 270, i));
            steels.add(new Steel(basicX - 300, i));
        }
        
        walls.add(new Wall(basicX - 270, 180));
        walls.add(new Wall(basicX - 270, 210));
        walls.add(new Wall(basicX - 300, 180));
        walls.add(new Wall(basicX - 300, 210));
        
        /*中间上面的地图*/
//        steels.add(new Steel(basicX + 60, 0));
//        steels.add(new Steel(basicX + 60, 30));
//        steels.add(new Steel(basicX + 90, 0));
//        steels.add(new Steel(basicX + 90, 30));
        
        for (int i = 60; i <=120 ; i += 30) {
            walls.add(new Wall(basicX + 60, i));
            walls.add(new Wall(basicX + 90, i));
        }
        for (int i = basicX + 90; i >= basicX - 60; i -= 30) {
            walls.add(new Wall(i, 90));
            walls.add(new Wall(i, 120));
        }
        
        
        /*右边的地图*/
        for (int i = basicX + 300; i <= basicX + 510; i += 30) {
            walls.add(new Wall(i, basicY + 30));
            walls.add(new Wall(i, basicY));
        }
        walls.add(new Wall(basicX + 510, basicY - 30));
        walls.add(new Wall(basicX + 510, basicY - 60));
        walls.add(new Wall(basicX + 480, basicY - 30));
        walls.add(new Wall(basicX + 480, basicY - 60));
        walls.add(new Wall(basicX + 330, basicY - 30));
        walls.add(new Wall(basicX + 330, basicY - 60));
        walls.add(new Wall(basicX + 300, basicY - 30));
        walls.add(new Wall(basicX + 300, basicY - 60));
        for (int i = basicX + 300; i <= basicX + 510; i += 60) {
            rivers.add(new River(i, basicY - 180));
        }
        
        for (int i = basicY - 210; i >= basicY - 480; i -= 30) {
            walls.add(new Wall(basicX + 510, i));
            walls.add(new Wall(basicX + 480, i));
        }
        for (int i = basicY - 480; i >= basicY - 620; i -= 60) {
            grass.add(new Grass(basicX + 420, i));
        }
        
        walls.add(new Wall(basicX + 360, basicY - 390));
        walls.add(new Wall(basicX + 360, basicY - 420));
        walls.add(new Wall(basicX + 390, basicY - 390));
        walls.add(new Wall(basicX + 390, basicY - 420));
        walls.add(new Wall(basicX + 300, basicY - 390));
        walls.add(new Wall(basicX + 300, basicY - 420));
        walls.add(new Wall(basicX + 330, basicY - 390));
        walls.add(new Wall(basicX + 330, basicY - 420));
        
        steels.add(new Steel(x - 18 - 30, basicY - 620));
        steels.add(new Steel(x - 18 - 60, basicY - 620));
        steels.add(new Steel(x - 18 - 30, basicY - 590));
        steels.add(new Steel(x - 18 - 60, basicY - 590));
        
        for (int i = x - 18 - 90; i >= x - 18 - 360; i -= 30) {
            for (int j = 60; j <= 150; j += 30) {
                walls.add(new Wall(i, j));
            }
        }
        
    }
    
}

















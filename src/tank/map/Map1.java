package tank.map;

import java.util.List;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Map1 {

    private int x = WIDTH;
    private int y = HEIGHT;

    /**这是家（home）的x,y坐标*/
    private int basicX = (x - 60) / 2;
    private int basicY = (y - 60) - 40;

    public Map1(List<BaseBuilding> walls, List<BaseBuilding> steels, List<BaseBuilding> grass, List<BaseBuilding> river) {
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
        
        //左手边石墙
        steels.add(new Steel(60, basicY - 30));
        steels.add(new Steel(60, basicY - 60));
        steels.add(new Steel(90, basicY - 30));
        steels.add(new Steel(90, basicY - 60));
        
        //右手边石墙
        steels.add(new Steel(x - 18 - 90, basicY - 30));
        steels.add(new Steel(x - 18 - 90, basicY - 60));
        steels.add(new Steel(x - 18 - 120, basicY - 30));
        steels.add(new Steel(x - 18 - 120, basicY - 60));
        
        //中间石墙
        steels.add(new Steel(basicX, 180));
        steels.add(new Steel(basicX, 210));
        steels.add(new Steel(basicX + 30, 180));
        steels.add(new Steel(basicX + 30, 210));
        
        steels.add(new Steel(0, y / 2 - 30));
        steels.add(new Steel(30, y / 2 - 30));
        steels.add(new Steel(x - 18 - 30, y / 2 - 30));
        steels.add(new Steel(x - 18 - 60, y / 2 - 30));
        /*****************石墙end*****************/
        
        //左手边第一列土墙
        walls.add(new Wall(60, basicY - 90));
        walls.add(new Wall(60, basicY - 120));
        walls.add(new Wall(60, basicY - 150));
        walls.add(new Wall(60, basicY - 180));
        walls.add(new Wall(60, basicY - 210));
        walls.add(new Wall(60, basicY - 240));
        walls.add(new Wall(90, basicY - 90));
        walls.add(new Wall(90, basicY - 120));
        walls.add(new Wall(90, basicY - 150));
        walls.add(new Wall(90, basicY - 180));
        walls.add(new Wall(90, basicY - 210));
        walls.add(new Wall(90, basicY - 240));
        
        walls.add(new Wall(60, 60));
        walls.add(new Wall(60, 90));
        walls.add(new Wall(60, 120));
        walls.add(new Wall(60, 150));
        walls.add(new Wall(60, 180));
        walls.add(new Wall(60, 210));
        walls.add(new Wall(60, 240));
        walls.add(new Wall(60, 270));
        walls.add(new Wall(90, 60));
        walls.add(new Wall(90, 90));
        walls.add(new Wall(90, 120));
        walls.add(new Wall(90, 150));
        walls.add(new Wall(90, 180));
        walls.add(new Wall(90, 210));
        walls.add(new Wall(90, 240));
        walls.add(new Wall(90, 270));
        
        
        
        //左手边第二列土墙
        walls.add(new Wall(60 + 150, basicY - 90));
        walls.add(new Wall(60 + 150, basicY - 120));
        walls.add(new Wall(60 + 150, basicY - 150));
        walls.add(new Wall(60 + 150, basicY - 180));
        walls.add(new Wall(60 + 150, basicY - 210));
        walls.add(new Wall(60 + 150, basicY - 240));
        walls.add(new Wall(60 + 150, basicY - 270));
        walls.add(new Wall(90 + 150, basicY - 90));
        walls.add(new Wall(90 + 150, basicY - 120));
        walls.add(new Wall(90 + 150, basicY - 150));
        walls.add(new Wall(90 + 150, basicY - 180));
        walls.add(new Wall(90 + 150, basicY - 210));
        walls.add(new Wall(90 + 150, basicY - 240));
        walls.add(new Wall(90 + 150, basicY - 270));
        
        walls.add(new Wall(60 + 150, 60));
        walls.add(new Wall(60 + 150, 90));
        walls.add(new Wall(60 + 150, 120));
        walls.add(new Wall(60 + 150, 150));
        walls.add(new Wall(60 + 150, 180));
        walls.add(new Wall(60 + 150, 210));
        walls.add(new Wall(60 + 150, 240));
        walls.add(new Wall(60 + 150, 270));
        walls.add(new Wall(90 + 150, 60));
        walls.add(new Wall(90 + 150, 90));
        walls.add(new Wall(90 + 150, 120));
        walls.add(new Wall(90 + 150, 150));
        walls.add(new Wall(90 + 150, 180));
        walls.add(new Wall(90 + 150, 210));
        walls.add(new Wall(90 + 150, 240));
        walls.add(new Wall(90 + 150, 270));
        
        //右手边第一列土墙
        walls.add(new Wall(x - 18 - 90, basicY - 90));
        walls.add(new Wall(x - 18 - 90, basicY - 120));
        walls.add(new Wall(x - 18 - 90, basicY - 150));
        walls.add(new Wall(x - 18 - 90, basicY - 180));
        walls.add(new Wall(x - 18 - 90, basicY - 210));
        walls.add(new Wall(x - 18 - 90, basicY - 240));
        walls.add(new Wall(x - 18 - 120, basicY -90));
        walls.add(new Wall(x - 18 - 120, basicY - 120));
        walls.add(new Wall(x - 18 - 120, basicY - 150));
        walls.add(new Wall(x - 18 - 120, basicY - 180));
        walls.add(new Wall(x - 18 - 120, basicY - 210));
        walls.add(new Wall(x - 18 - 120, basicY - 240));
        
        walls.add(new Wall(x - 18 - 90, 60));
        walls.add(new Wall(x - 18 - 90, 90));
        walls.add(new Wall(x - 18 - 90, 120));
        walls.add(new Wall(x - 18 - 90, 150));
        walls.add(new Wall(x - 18 - 90, 180));
        walls.add(new Wall(x - 18 - 90, 210));
        walls.add(new Wall(x - 18 - 90, 240));
        walls.add(new Wall(x - 18 - 90, 270));
        walls.add(new Wall(x - 18 - 120, 60));
        walls.add(new Wall(x - 18 - 120, 90));
        walls.add(new Wall(x - 18 - 120, 120));
        walls.add(new Wall(x - 18 - 120, 150));
        walls.add(new Wall(x - 18 - 120, 180));
        walls.add(new Wall(x - 18 - 120, 210));
        walls.add(new Wall(x - 18 - 120, 240));
        walls.add(new Wall(x - 18 - 120, 270));
        
        
        //右手边第二列土墙
        walls.add(new Wall(x - 18 - 240, basicY - 90));
        walls.add(new Wall(x - 18 - 240, basicY - 120));
        walls.add(new Wall(x - 18 - 240, basicY - 150));
        walls.add(new Wall(x - 18 - 240, basicY - 180));
        walls.add(new Wall(x - 18 - 240, basicY - 210));
        walls.add(new Wall(x - 18 - 240, basicY - 240));
        walls.add(new Wall(x - 18 - 240, basicY - 270));
        walls.add(new Wall(x - 18 - 270, basicY - 90));
        walls.add(new Wall(x - 18 - 270, basicY - 120));
        walls.add(new Wall(x - 18 - 270, basicY - 150));
        walls.add(new Wall(x - 18 - 270, basicY - 180));
        walls.add(new Wall(x - 18 - 270, basicY - 210));
        walls.add(new Wall(x - 18 - 270, basicY - 240));
        walls.add(new Wall(x - 18 - 270, basicY - 270));
        
        walls.add(new Wall(x - 18 - 240, 60));
        walls.add(new Wall(x - 18 - 240, 90));
        walls.add(new Wall(x - 18 - 240, 120));
        walls.add(new Wall(x - 18 - 240, 150));
        walls.add(new Wall(x - 18 - 240, 180));
        walls.add(new Wall(x - 18 - 240, 210));
        walls.add(new Wall(x - 18 - 240, 240));
        walls.add(new Wall(x - 18 - 240, 270));
        walls.add(new Wall(x - 18 - 270, 60));
        walls.add(new Wall(x - 18 - 270, 90));
        walls.add(new Wall(x - 18 - 270, 120));
        walls.add(new Wall(x - 18 - 270, 150));
        walls.add(new Wall(x - 18 - 270, 180));
        walls.add(new Wall(x - 18 - 270, 210));
        walls.add(new Wall(x - 18 - 270, 240));
        walls.add(new Wall(x - 18 - 270, 270));
        
        
        //中间两侧的土墙
        walls.add(new Wall(60 + 90, y / 2 - 30));
        walls.add(new Wall(60 + 120, y / 2 - 30));
        walls.add(new Wall(60 + 150, y / 2 - 30));
        walls.add(new Wall(60 + 180, y / 2 - 30));
        walls.add(new Wall(60 + 210, y / 2 - 30));
        walls.add(new Wall(60 + 240, y / 2 - 30));
        walls.add(new Wall(60 + 90, y / 2 - 60));
        walls.add(new Wall(60 + 120, y / 2 - 60));
        walls.add(new Wall(60 + 150, y / 2 - 60));
        walls.add(new Wall(60 + 180, y / 2 - 60));
        walls.add(new Wall(60 + 210, y / 2 - 60));
        walls.add(new Wall(60 + 240, y / 2 - 60));
        
        walls.add(new Wall(x - 18 - 180, y / 2 - 30));
        walls.add(new Wall(x - 18 - 210, y / 2 - 30));
        walls.add(new Wall(x - 18 - 240, y / 2 - 30));
        walls.add(new Wall(x - 18 - 270, y / 2 - 30));
        walls.add(new Wall(x - 18 - 300, y / 2 - 30));
        walls.add(new Wall(x - 18 - 330, y / 2 - 30));
        walls.add(new Wall(x - 18 - 180, y / 2 - 60));
        walls.add(new Wall(x - 18 - 210, y / 2 - 60));
        walls.add(new Wall(x - 18 - 240, y / 2 - 60));
        walls.add(new Wall(x - 18 - 270, y / 2 - 60));
        walls.add(new Wall(x - 18 - 300, y / 2 - 60));
        walls.add(new Wall(x - 18 - 330, y / 2 - 60));
        
        
        /*中间部分的土墙*/
        //左下边
        walls.add(new Wall(basicX - 30, basicY - 150));
        walls.add(new Wall(basicX - 30, basicY - 180));
        walls.add(new Wall(basicX - 30, basicY - 210));
        walls.add(new Wall(basicX - 30, basicY - 240));
        walls.add(new Wall(basicX - 30, basicY - 270));
        walls.add(new Wall(basicX - 30, basicY - 300));
        walls.add(new Wall(basicX - 30, basicY - 330));
        walls.add(new Wall(basicX - 30, basicY - 360));
        walls.add(new Wall(basicX - 30, basicY - 450));
        walls.add(new Wall(basicX - 30, basicY - 480));
        walls.add(new Wall(basicX - 60, basicY - 150));
        walls.add(new Wall(basicX - 60, basicY - 180));
        walls.add(new Wall(basicX - 60, basicY - 210));
        walls.add(new Wall(basicX - 60, basicY - 240));
        walls.add(new Wall(basicX - 60, basicY - 270));
        walls.add(new Wall(basicX - 60, basicY - 300));
        walls.add(new Wall(basicX - 60, basicY - 330));
        walls.add(new Wall(basicX - 60, basicY - 360));
        walls.add(new Wall(basicX - 60, basicY - 450));
        walls.add(new Wall(basicX - 60, basicY - 480));
        walls.add(new Wall(basicX - 90, basicY - 150));
        walls.add(new Wall(basicX - 90, basicY - 180));
        walls.add(new Wall(basicX - 90, basicY - 210));
        walls.add(new Wall(basicX - 90, basicY - 240));
        walls.add(new Wall(basicX - 90, basicY - 270));
        walls.add(new Wall(basicX - 90, basicY - 300));
        walls.add(new Wall(basicX - 90, basicY - 330));
        walls.add(new Wall(basicX - 90, basicY - 360));
        walls.add(new Wall(basicX - 90, basicY - 450));
        walls.add(new Wall(basicX - 90, basicY - 480));
        
        walls.add(new Wall(basicX, basicY - 300));
        walls.add(new Wall(basicX, basicY - 330));
        
        walls.add(new Wall(basicX - 120, basicY - 450));
        walls.add(new Wall(basicX - 120, basicY - 480));
        
        //右下边
        walls.add(new Wall(basicX + 60, basicY - 150));
        walls.add(new Wall(basicX + 60, basicY - 180));
        walls.add(new Wall(basicX + 60, basicY - 210));
        walls.add(new Wall(basicX + 60, basicY - 240));
        walls.add(new Wall(basicX + 60, basicY - 270));
        walls.add(new Wall(basicX + 60, basicY - 300));
        walls.add(new Wall(basicX + 60, basicY - 330));
        walls.add(new Wall(basicX + 60, basicY - 360));
        walls.add(new Wall(basicX + 60, basicY - 450));
        walls.add(new Wall(basicX + 60, basicY - 480));
        walls.add(new Wall(basicX + 90, basicY - 150));
        walls.add(new Wall(basicX + 90, basicY - 180));
        walls.add(new Wall(basicX + 90, basicY - 210));
        walls.add(new Wall(basicX + 90, basicY - 240));
        walls.add(new Wall(basicX + 90, basicY - 270));
        walls.add(new Wall(basicX + 90, basicY - 300));
        walls.add(new Wall(basicX + 90, basicY - 330));
        walls.add(new Wall(basicX + 90, basicY - 360));
        walls.add(new Wall(basicX + 90, basicY - 450));
        walls.add(new Wall(basicX + 90, basicY - 480));
        walls.add(new Wall(basicX + 120, basicY - 150));
        walls.add(new Wall(basicX + 120, basicY - 180));
        walls.add(new Wall(basicX + 120, basicY - 210));
        walls.add(new Wall(basicX + 120, basicY - 240));
        walls.add(new Wall(basicX + 120, basicY - 270));
        walls.add(new Wall(basicX + 120, basicY - 300));
        walls.add(new Wall(basicX + 120, basicY - 330));
        walls.add(new Wall(basicX + 120, basicY - 360));
        walls.add(new Wall(basicX + 120, basicY - 450));
        walls.add(new Wall(basicX + 120, basicY - 480));
        
        walls.add(new Wall(basicX + 30, basicY - 300));
        walls.add(new Wall(basicX + 30, basicY - 330));
        
        walls.add(new Wall(basicX + 150, basicY - 450));
        walls.add(new Wall(basicX + 150, basicY - 480));
        
        //左上边
        walls.add(new Wall(basicX - 30, 60));
        walls.add(new Wall(basicX - 30, 90));
        walls.add(new Wall(basicX - 30, 120));
        walls.add(new Wall(basicX - 30, 150));
        walls.add(new Wall(basicX - 30, 180)); 
        walls.add(new Wall(basicX - 30, 210));
        walls.add(new Wall(basicX - 30, 230));
        walls.add(new Wall(basicX - 60, 60));
        walls.add(new Wall(basicX - 60, 90));
        walls.add(new Wall(basicX - 60, 120));
        walls.add(new Wall(basicX - 60, 150));
        walls.add(new Wall(basicX - 60, 180)); 
        walls.add(new Wall(basicX - 60, 210));
        walls.add(new Wall(basicX - 60, 230));
        walls.add(new Wall(basicX - 90, 60));
        walls.add(new Wall(basicX - 90, 90));
        walls.add(new Wall(basicX - 90, 120));
        walls.add(new Wall(basicX - 90, 150));
        walls.add(new Wall(basicX - 90, 180)); 
        walls.add(new Wall(basicX - 90, 210));
        walls.add(new Wall(basicX - 90, 230));
        
        //右上边
        walls.add(new Wall(basicX + 60, 60));
        walls.add(new Wall(basicX + 60, 90));
        walls.add(new Wall(basicX + 60, 120));
        walls.add(new Wall(basicX + 60, 150));
        walls.add(new Wall(basicX + 60, 180)); 
        walls.add(new Wall(basicX + 60, 210));
        walls.add(new Wall(basicX + 60, 230));
        walls.add(new Wall(basicX + 90, 60));
        walls.add(new Wall(basicX + 90, 90));
        walls.add(new Wall(basicX + 90, 120));
        walls.add(new Wall(basicX + 90, 150));
        walls.add(new Wall(basicX + 90, 180)); 
        walls.add(new Wall(basicX + 90, 210));
        walls.add(new Wall(basicX + 90, 230));
        walls.add(new Wall(basicX + 120, 60));
        walls.add(new Wall(basicX + 120, 90));
        walls.add(new Wall(basicX + 120, 120));
        walls.add(new Wall(basicX + 120, 150));
        walls.add(new Wall(basicX + 120, 180)); 
        walls.add(new Wall(basicX + 120, 210));
        walls.add(new Wall(basicX + 120, 230));
        
    }
    
}
























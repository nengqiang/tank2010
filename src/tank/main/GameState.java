package tank.main;

import tank.main.bean.*;
import tank.main.consts.AwardTypeEnum;
import tank.main.consts.Constants;
import tank.main.gameresource.Img;
import tank.map.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class GameState extends JPanel {

    private static final long serialVersionUID = 1L;
    /**
     * 以下两坐标控制两玩家坦克初始位置
     */
    private static int xLong = 120;
    private static int yLong = 40;
    
    /**
     * 创建对象
     */
    private SelectTank selectTank = new SelectTank();

    /**
     * xLong yLong blood fire images
     */
    private HeroTank heroTank = new HeroTank(xLong, yLong, 3, 1, Img.sHero1);
    private HeroTank hero2 = new HeroTank(-xLong, yLong, 3, 1, Img.sHero2);
    
    private List<Bullet> heroBullets = new ArrayList<>();
    private List<Bullet> heroBullets2 = new ArrayList<>();
    
    private List<EnemyTank> tanks = new ArrayList<>();
    private List<Bullet> enemyBullets = new ArrayList<>();
    private List<Explode> explodes = new ArrayList<>();
    private List<Award> awards = new ArrayList<>();
    private Home home = new Home();
    private List<BaseBuilding> walls = new ArrayList<>();
    private List<BaseBuilding> steels = new ArrayList<>();
    private List<BaseBuilding> grass = new ArrayList<>();
    private List<BaseBuilding> rivers = new ArrayList<>();

    private PaintObjs paintObjs = new PaintObjs(selectTank, heroTank, hero2, heroBullets, heroBullets2, tanks, enemyBullets, explodes, awards, home, walls, steels, grass, rivers);
    private Paint paint = new Paint(paintObjs);
    
    /**
     * 游戏状态
     */
    private static int state = 0;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int OVER = 3;

    /**记录玩家一玩或玩家二是否game over*/
    private static boolean isOver1;
    private static boolean isOver2;

    /**game over图片的x、y坐标*/
    private static int overX = (Constants.WIDTH - Img.gameOver.getWidth()) / 2;
    private static int overY = (Constants.HEIGHT - Img.gameOver.getHeight() - 80);
    private static int level = 0;
    private static int enemyNum1 = -1;
    private static int enemyNum2 = -1;
    
    /**
     * 创建敌人对象
     */
    private EnemyTank nextOne() {
        Random rand = new Random();
        EnemyTank sEnemy = new EnemyTank(Img.sEnemys);
        int type = rand.nextInt(50);
        if (type < 5 + level) {
            //x y blood speed images
            return new EnemyTank(0, 0, 8, 1, Img.lEnemys);
        }
        if (type < 15 + level) {
            return new EnemyTank(Constants.WIDTH - sEnemy.getWidth() - 18, 0, 4, 3, Img.mEnemys);
        }
        if (type < 25) {
            return new EnemyTank(0, 0, 2, 2, Img.sEnemys);
        } 
        if (type < 40){            
            return new EnemyTank(Constants.WIDTH - sEnemy.getWidth() - 18, 0, 2, 2, Img.sEnemys);
        } else {
            return new EnemyTank((Constants.WIDTH - sEnemy.getWidth()) / 2, 0, 2, 2, Img.sEnemys);
        }
        
    }
    
    private int enterIndex = 0;

    /**
     * 敌人入场
     */
    private void enterAction() {
        /*每隔2秒进行一次入场判断*/
        enterIndex++;
        int idx = 2000 / Constants.INTERVAL;
        if (enterIndex >= idx) {
            enterIndex = 0;
            /*控制场中敌人数量为6*/
            int enemyNumInArea = 6;
            if (tanks.size() < enemyNumInArea) {
                if (enemyNum1 > 0) {
                    EnemyTank tank = nextOne();
                    tanks.add(tank);
                    enemyNum1--;
                }
            }
        }
        
    }
    
    private int enemyBulletIndex = 0;

    /**
     * 敌方子弹入场
     * 10ms走一次
     */
    private void eShootAction() {
        enemyBulletIndex++;
        int idx = 1200 / Constants.INTERVAL;
        if (enemyBulletIndex >= idx) {
            enemyBulletIndex = 0;
            for (EnemyTank tank : tanks) {
                Bullet e = tank.shoot();
                enemyBullets.add(e);
            }
        }
        
    }  

    /**
     * 控制发射子弹方法执行与否
     */
    private boolean shoot;
    private boolean shoot2;
    private int shootIndex = 0;
    /**
     * 英雄坦克子弹入场方法
     * 10ms走一次
     */
    private void shootAction(HeroTank tank, List<Bullet> heroBullets) {
       shootIndex++;
       int idx = 100 / Constants.INTERVAL;
       if(shootIndex >= idx) {
           shootIndex = 0;
           List<Bullet> bs = tank.shoot();
           if (heroBullets.size() < tank.getFire()) {
               heroBullets.addAll(bs);
               MusicPlay.fireMusic();
           }
       }
    }

    /**
     * 射击检测
     */
    private void hitAction() {
        /*敌方子弹射击到我方坦克*/
        HitAction.bulletHitHero(enemyBullets, heroTank, explodes);
        /*敌方子弹射击到土墙*/
        HitAction.bulletsHitWall(enemyBullets, walls);
        /*敌方子弹射击到石墙*/
        HitAction.enemyBulletHitSteel(enemyBullets, steels);

        /*我方子弹射击到边界*/
        HitAction.bulletHitBounds(heroBullets, explodes);
        /*我方子弹射击到敌方子弹*/
        HitAction.bulletHitBullet(heroBullets, enemyBullets);
        /*我方子弹射击到敌方坦克*/
        HitAction.bulletHitEnemy(heroBullets, tanks, explodes, awards);
        /*英雄1打到家*/
        /*敌方子弹打到家*/
        /*如果家被打了，那么就不再判断家与子弹的碰撞*/
        if (state != OVER) {
            boolean isHit = HitAction.bulletsHitHome(heroBullets, enemyBullets, home, explodes);
            if (isHit) {
                state = OVER;
                //rePlay();
            }
        }
        /*我方子弹射击到土墙*/
        HitAction.heroBulletsHitWall(heroBullets, walls);
        /*我方子弹射击到石墙*/
        HitAction.heroBulletHitSteel(heroBullets, steels, explodes);

        /*对玩家二的射击检测*/
        if (selectTank.isTwoPlayers()) {
            /*敌方子弹射击到我方坦克2*/
            HitAction.bulletHitHero2(enemyBullets, hero2, explodes);
            /*我方子弹射击到边界*/
            HitAction.bulletHitBounds(heroBullets2, explodes);
            /*我方子弹射击到敌方子弹*/
            HitAction.bulletHitBullet(heroBullets2, enemyBullets);
            /*我方子弹射击到敌方坦克*/
            HitAction.bulletHitEnemy(heroBullets2, tanks, explodes, awards);
            /*我方子弹射击到我方子弹*/
            HitAction.bulletHitBullet(heroBullets, heroBullets2);
            /*英雄2打到家*/
            if (state != OVER) {
                boolean isHit = HitAction.bulletsHitHome(heroBullets2, enemyBullets, home, explodes);
                if (isHit) {
                    state = OVER;
                    //rePlay();
                }
            }
            /*我方英雄2射击到土墙*/
            HitAction.heroBulletsHitWall(heroBullets2, walls);
            /*我方英雄2射击到石墙*/
            HitAction.heroBulletHitSteel(heroBullets2, steels, explodes);
        }
    }

    /**
     * 碰撞检测
     * 10ms走一次
     */
    private void knockAction() {
        if (!isOver1) {
            /*我方坦克1与奖励的碰撞*/
            heroEatAward();
            /*我方坦克1撞土墙*/
            HitAction.heroKnockBuildings(heroTank, walls);
            /*我方坦克1撞石墙*/
            HitAction.heroKnockBuildings(heroTank, steels);
            /*我方坦克1撞到河*/
            HitAction.heroKnockBuildings(heroTank, rivers);
            /*玩家一撞到敌方坦克*/
            HitAction.heroKnockEnemy(heroTank, tanks);
            /*敌方坦克撞到玩家一*/
            HitAction.enemyKnockHero(tanks, heroTank);
        }
        
        if (selectTank.isTwoPlayers() && !isOver2) {
            /*玩家二坦克与奖励的碰撞*/
            hero2EatAward();
            /*我方坦克2撞土墙*/
            HitAction.heroKnockBuildings(hero2, walls);
            /*我方坦克2撞石墙*/
            HitAction.heroKnockBuildings(hero2, steels);
            /*我方坦克2撞到河*/
            HitAction.heroKnockBuildings(hero2, rivers);
            /*玩家二撞到敌方坦克*/
            HitAction.heroKnockEnemy(hero2, tanks);
            /*敌方坦克撞到玩家二*/
            HitAction.enemyKnockHero(tanks, hero2);
            /*两玩家相撞*/
            HitAction.heroKnockHero(heroTank, hero2);
        }
        
        /*敌方坦克撞到敌方坦克*/
        HitAction.enemyKnockEnemy(tanks);
        /*敌方坦克撞土墙*/
        HitAction.enemyKnockBuildings(tanks, walls);
        /*敌方坦克撞石墙*/
        HitAction.enemyKnockBuildings(tanks, steels);
        /*敌方坦克撞到河*/
        HitAction.enemyKnockBuildings(tanks, rivers);
    }
    
    private int awardIndex = 0;

    /**
     * 10ms走一次
     */
    private void heroEatAward() {
        Iterator<Award> awardIt = awards.iterator();
        while (awardIt.hasNext()) {
            Award a = awardIt.next();
            int awardType = a.getAwardType();
            if (a.isEaten(heroTank)) {
                MusicPlay.addMusic();
                awardIt.remove();
                switch (AwardTypeEnum.getEnumByType(awardType)) {
                    case ADD_BLOOD_FIRE:
                        if (heroTank.getBlood() < 3) {
                            heroTank.addBlood(1);
                        }
                        if (heroTank.getFire() < 4) {
                            heroTank.addFire(1);
                        }
                        break;
                    case ADD_LIFE:
                        heroTank.setImages(Img.lHero1);
                        heroTank.addLifeNum(1);
                        break;
                    case ENEMY_EXPLODE:
                        for (EnemyTank tank : tanks) {
                            explodes.add(new Explode(tank));
                        }
                        MusicPlay.blastMusic();
                        enemyNum2 -= tanks.size();
                        tanks.clear();
                        break;
                    default: break;
                }
            } else {
                awardIndex++;
                //10s过后奖励自动消失
                int idx = 10000 / Constants.INTERVAL;
                if (awardIndex >= idx) {
                    awardIndex = 0;
                    awardIt.remove();
                }
            }
        }
    }

    private int awardIndex2 = 0;

    /**
     * 10ms走一次
     */
    private void hero2EatAward() {
        Iterator<Award> awardIt = awards.iterator();
        while (awardIt.hasNext()) {
            Award a = awardIt.next();
            int awardType = a.getAwardType();
            if (a.isEaten(hero2)) {
                awardIt.remove();
                MusicPlay.addMusic();
                switch (AwardTypeEnum.getEnumByType(awardType)) {
                    case ADD_BLOOD_FIRE:
                        if (hero2.getBlood() < 3) {
                            hero2.addBlood(1);
                        }
                        if (hero2.getFire() < 4) {
                            hero2.addFire(1);
                        }
                        break;
                    case ADD_LIFE:
                        hero2.setImages(Img.lHero2);
                        hero2.addLifeNum(1);
                        break;
                    case ENEMY_EXPLODE:
                        for (EnemyTank tank : tanks) {
                            explodes.add(new Explode(tank));
                        }
                        MusicPlay.blastMusic();
                        enemyNum2 -= tanks.size();
                        tanks.clear();
                        break;
                    default: break;
                }
            } else {
                awardIndex2++;
                //10s过后奖励自动消失
                int idx = 10000 / Constants.INTERVAL;
                if (awardIndex2 >= idx) {
                    awardIndex2 = 0;
                    awardIt.remove();
                }
            }
        }
    }

    /**
     * 各种对象运动方法
     * 10ms走一次
     */
    private void stepAction() {
        if (!isOver1 && state != OVER) {
            heroTank.move();
            for (Bullet b : heroBullets) {
                b.step();
            }
        }
        if (selectTank.isTwoPlayers() && !isOver2 && state != OVER) {
            hero2.move();
            for (Bullet b : heroBullets2) {
                b.step();
            }
        }
        for (EnemyTank tank : tanks) {
            tank.step();
        }
        for (Bullet b : enemyBullets) {
            b.step();
        }
    }
    
    /**
     * 关卡负责方法
     */
    private void levelCheck() {
        if (enemyNum2 <= 0) {
            repaint();
            MusicPlay.startMusic();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            level++ ;
            enemyNum1 = 5 + level;
            enemyNum2 = 5 + level;
            heroTank.setPosition(xLong, yLong);
            heroTank.setImage(heroTank.getImages()[0]);
            /*过关将死去的英雄救活*/
            if (heroTank.getLifeNum() < 0) {
                heroTank.setLifeNum(0);
                isOver1 = false;
            }
            if (selectTank.isTwoPlayers()) {
                hero2.setPosition(-xLong, yLong);
                hero2.setImage(hero2.getImages()[0]);
                /*过关将死去的英雄救活*/
                if (hero2.getLifeNum() < 0) {
                    hero2.setLifeNum(0);
                    isOver2 = false;
                }
            }
            // 相关参数归零
            clear();
            /**
             * 每一关初始化地图
             */
            if (level % 3 == 1) {
                new Map1(walls, steels, grass, rivers);
            } else if (level % 3 == 2) {
                new Map2(walls, steels, grass, rivers);
            } else if (level % 3 == 0) {
                new Map10(walls, steels, grass, rivers);
            }
        }
    }
    
    /**
     * 检查游戏是否结束
     */
    private void checkGameOver() {
        if (selectTank.isTwoPlayers()) {
            if (heroTank.getLifeNum() < 0) {
                isOver1 = true;
            }
            if (hero2.getLifeNum() < 0) {
                isOver2 = true;
            }
            if (isOver1 && isOver2) {      
                state = OVER;
            }
        } else if (heroTank.getLifeNum() < 0) {
            isOver1 = true;
            state = OVER;
        }
        
    }

    private void rePlay() {
        /*游戏结束重启后参数复位*/
        heroTank.setImages(Img.sHero1);
        heroTank.setFire(1);
        heroTank.setBlood(3);
        heroTank.setPosition(xLong, yLong);
        heroTank.setImage(Img.sHero1[0]);
        heroTank.setLifeNum(0);
        hero2.setImages(Img.sHero2);
        hero2.setFire(1);
        hero2.setBlood(3);
        hero2.setPosition(-xLong, yLong);
        hero2.setImage(Img.sHero2[0]);
        hero2.setLifeNum(0);
        // 所有参数复位
        clear();
        level = 1;
        enemyNum1 = 5 + level;
        enemyNum2 = 5 + level;
        isOver1 = false;
        isOver2 = false;
        overX = (Constants.WIDTH - Img.gameOver.getWidth()) / 2;
        overY = (Constants.HEIGHT - Img.gameOver.getHeight() - 80);
        new Map1(walls, steels, grass, rivers);
    }

    /**
     * 清场
     */
    private void clear() {
        selectIndex = 0;
        shootIndex = 0;
        enterIndex = 0;
        enemyBulletIndex = 0;
        awardIndex = 0;
        awardIndex2 = 0;
        tanks.clear();
        enemyBullets.clear();
        heroBullets.clear();
        heroBullets2.clear();
        explodes.clear();
        awards.clear();
        // 建筑物清除
        walls.clear();
        steels.clear();
        grass.clear();
        rivers.clear();
    }
    
    private void overAction() {
        if (overY > (Constants.HEIGHT - Img.gameOver.getHeight() - 80) / 2) {
            overY -= 2;
        }
    }
    
    private int selectIndex = 0;
    /**
     * 游戏状态，里面调用各种游戏执行的方法
     * 10ms走一次
     */
    void gameState() {
        checkGameOver();
        switch (state) {
        case START: 
            selectIndex++;
            // 70ms走一次
            int idx = 70 / Constants.INTERVAL;
            if (selectIndex >= idx) {
                selectIndex = 0;
                selectTank.step();
            }
            repaint();
            break;
        case PAUSE:
            repaint();
            break;
        case OVER:
            /*此处的方法是game over时，敌方还能动，但是我方没有坦克了*/
            overAction();
            enterAction();
            eShootAction();
            // 射击检测
            hitAction();
            // 碰撞检测
            knockAction();
            stepAction();
            repaint();
            break;
        case RUNNING: 
            enterAction();
            eShootAction();
            if (!isOver1 && shoot) {
                shootAction(heroTank, heroBullets);
            }
            if (selectTank.isTwoPlayers() && !isOver2 && shoot2) {
                shootAction(hero2, heroBullets2);
            }
            // 射击检测
            hitAction();
            // 碰撞检测
            knockAction();
            stepAction();
            levelCheck();
            // 10ms走一次
            repaint();
            break;
        default : break;
        }
    }
    
    /**
     * 画的方法，调用所有Paint里面的方法
     * 10ms走一次
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (state) {
            case START: 
                paint.paintStart(g);
                paint.paintSelectTank(g);
            break;
            case PAUSE:
                paint.paintPause(g);
                break;
            case OVER:
                paint.paintRunning(g);
                paint.paintOver(g);
                break;
            case RUNNING:
                if (enemyNum2 <= 0) {
                    paint.paintLevel(g);
                } else {
                    paint.paintRunning(g);
                }
                break;
            default : paint.paintStart(g);
        }
    }
    
    /**
     * 按键监听进行游戏 
     */
    class Listener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    heroTank.setUp(true);
                    break;
                case KeyEvent.VK_S:
                    heroTank.setDown(true);
                    break;
                case KeyEvent.VK_A:
                    heroTank.setLeft(true);
                    break;
                case KeyEvent.VK_D:
                    heroTank.setRight(true);
                    break;
                case KeyEvent.VK_UP:
                    selectTank.setUpCase(true);
                    hero2.setUp(true);
                    break;
                case KeyEvent.VK_DOWN:
                    selectTank.setDownCase(true);
                    hero2.setDown(true);
                    break;
                case KeyEvent.VK_LEFT:
                    hero2.setLeft(true);
                    break;
                case KeyEvent.VK_RIGHT:
                    hero2.setRight(true);
                    break;
                case KeyEvent.VK_J:
                    shoot = true;
                    break;
//                case KeyEvent.VK_NUMPAD4:
                case KeyEvent.VK_BACK_SLASH:
                    shoot2 = true;
                    break;
                case KeyEvent.VK_P:
                    if (state == RUNNING) {
                        state = PAUSE;
                    } else if (state == PAUSE) {
                        state = RUNNING;
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (state == START) {
                        state = RUNNING;
                    } else if (state == OVER) {
                        rePlay();
                        state = START;
                    }
                    break;
                    default: break;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                heroTank.setUp(false);
                break;
            case KeyEvent.VK_S:
                heroTank.setDown(false);
                break;
            case KeyEvent.VK_A:
                heroTank.setLeft(false);
                break;
            case KeyEvent.VK_D:
                heroTank.setRight(false);
                break; 
            case KeyEvent.VK_UP:
                selectTank.setUpCase(false);
                hero2.setUp(false);
                break;
            case KeyEvent.VK_DOWN:
                selectTank.setDownCase(false);
                hero2.setDown(false);
                break;
            case KeyEvent.VK_LEFT:
                hero2.setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                hero2.setRight(false);
                break;
            case KeyEvent.VK_J:
                shoot = false;
                break;
//            case KeyEvent.VK_NUMPAD4:
                case KeyEvent.VK_BACK_SLASH:
                shoot2 = false;
                break;
                default: break;
            }
        }
    }
    
    public Listener getListener() {
        return new Listener();
    }

    public static void minusEnemyNum2(int n) {
        enemyNum2 -= n;
    }

    public static int getOverX() {
        return overX;
    }

    public static int getOverY() {
        return overY;
    }

    public static int getState() {
        return state;
    }

    public static int getOVER() {
        return OVER;
    }

    public static boolean isIsOver1() {
        return isOver1;
    }

    public static boolean isIsOver2() {
        return isOver2;
    }

    public static int getLevel() {
        return level;
    }

    public static int getxLong() {
        return xLong;
    }

    public static int getyLong() {
        return yLong;
    }

    public static int getEnemyNum1() {
        return enemyNum1;
    }

    public static int getEnemyNum2() {
        return enemyNum2;
    }
}








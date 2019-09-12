package tank.main;

import java.util.Iterator;
import java.util.List;

import tank.main.bean.*;
import tank.main.consts.Constants;
import tank.main.gameresource.Img;
import tank.map.BaseBuilding;
import tank.map.Home;

/**
 * 该类包含射击检测、碰撞检测的各种静态方法
 *
 * @author henengqiang
 * @date 2019-09-05
 */
public class HitAction {
    
    public static void bulletHitBounds(List<Bullet> heroBullets, List<Explode> explodes) {
        Iterator<Bullet> it = heroBullets.iterator();
        while (it.hasNext()) {
            Bullet b = it.next();
            //边界检测写这里不写Paint类里是为了添加爆炸效果
            if (b.outOfBounds(new HeroTank())) {
                MusicPlay.hitMusic();
                explodes.add(new Explode(b));
                it.remove();
            }
        }
    }
    
    public static void bulletHitBullet(List<Bullet> bullets1, List<Bullet> bullets2) {
        Iterator<Bullet> ebIt = bullets2.iterator();
        while (ebIt.hasNext()) {
            Bullet eb = ebIt.next();
            Iterator<Bullet> hbIt = bullets1.iterator();
            while (hbIt.hasNext()) {
                Bullet hb = hbIt.next();
                if (eb.isHit(hb)) {
                    ebIt.remove();
                    hbIt.remove();
                }
            }
            
        }
        
    }
    
    public static void bulletHitEnemy(List<Bullet> heroBullets, List<EnemyTank> tanks, List<Explode> explodes, List<Award> awards) {
        Iterator<EnemyTank> tankIt = tanks.iterator();
        while (tankIt.hasNext()) {
            EnemyTank tank = tankIt.next();
            
            if (tank != null) {
                Iterator<Bullet> hbIt = heroBullets.iterator();
                while (hbIt.hasNext()) {
                    Bullet hb = hbIt.next();
                    if (tank.isHit(hb)) {
                        MusicPlay.hitMusic();
                        hbIt.remove();
                        tank.minusBlood(1);
                        //敌方坦克血量减一后进行血量检测，不同血量对应不同形态
                        checkEnemyLife(tank, tankIt, explodes, awards);
                    }
                }
            }
            
        }
    }

    public static void checkEnemyLife(EnemyTank tank, Iterator<EnemyTank> it, List<Explode> explodes, List<Award> awards) {
        /*判断敌方生命值，降低到一定生命值时变换形态*/
        if (tank.getBlood() <= 0) {
            MusicPlay.blastMusic();
            it.remove();
            // 添加爆炸效果
            explodes.add(new Explode(tank));
            GameState.minusEnemyNum2(1);
        } else if (tank.getBlood() == 4) {
            tank.setSpeed(3);
            tank.setImages(Img.mEnemys);
        } else if (tank.getBlood() == 2) {
            awards.add(new Award(tank.getX(), tank.getY(), Constants.RAND.nextInt(3)));
            tank.setSpeed(2);
            tank.setImages(Img.sEnemys);
        }
    }
    
    public static void bulletHitHero(List<Bullet> enemyBullets, HeroTank heroTank, List<Explode> explodes) {
        Iterator<Bullet> ebIt = enemyBullets.iterator();
        while (ebIt.hasNext()) {
            Bullet b = ebIt.next();
            if (heroTank.isHit(b)) {
                ebIt.remove();
                if (heroTank.getFire() > 1) {
                    heroTank.minusFire(1);
                }
                heroTank.minusBlood(1);
                //我方坦克血量减一后进行血量判断
                checkHeroLife(heroTank, explodes);
            }
        }
    }

    public static void checkHeroLife(HeroTank heroTank, List<Explode> explodes) {
        /*检测我方血量*/
        if (heroTank.getBlood() <= 0) {
            MusicPlay.heroBlastMusic();
            //死一次之后加成归0
            heroTank.minusLifeNum(1);
            heroTank.setImages(Img.sHero1);
            heroTank.setFire(1);
            explodes.add(new Explode(heroTank));
            heroTank.setBlood(3);
            heroTank.setPosition(GameState.getxLong(), GameState.getyLong());
            heroTank.setImage(Img.sHero1[0]);
        }
    }
    
    public static void bulletHitHero2(List<Bullet> enemyBullets, HeroTank hero2, List<Explode> explodes) {
        Iterator<Bullet> ebIt = enemyBullets.iterator();
        while (ebIt.hasNext()) {
            Bullet b = ebIt.next();
            if (hero2.isHit(b)) {
                ebIt.remove();
                if (hero2.getFire() > 1) {
                    hero2.minusFire(1);
                }
                hero2.minusBlood(1);
                //我方坦克血量减一后进行血量判断
                checkHero2Life(hero2, explodes);
            }
        }
    }

    public static void checkHero2Life(HeroTank heroTank, List<Explode> explodes) {
        /*检测我方血量*/
        if (heroTank.getBlood() <= 0) {
            MusicPlay.heroBlastMusic();
            //死一次之后加成归0
            heroTank.minusLifeNum(1);
            heroTank.setImages(Img.sHero2);
            heroTank.setFire(1);
            explodes.add(new Explode(heroTank));
            heroTank.setBlood(3);
            heroTank.setPosition(-GameState.getxLong(), GameState.getyLong());
            heroTank.setImage(Img.sHero2[0]);
        }
    }
    
    /**
     * 英雄1或敌方子弹打到家
     */
    public static boolean bulletsHitHome(List<Bullet> heroBullets, List<Bullet> enemyBullets, Home home, List<Explode> explodes) {
        if (hitHome(heroBullets, home, explodes)) {
            return true;
        }
        return hitHome(enemyBullets, home, explodes);
    }

    private static boolean hitHome(List<Bullet> bullets, Home home, List<Explode> explodes) {
        Iterator<Bullet> hbIt = bullets.iterator();
        while (hbIt.hasNext()) {
            Bullet b = hbIt.next();
            if (home.isHit(b)) {
                hbIt.remove();
                MusicPlay.heroBlastMusic();
                explodes.add(new Explode(home));
                MusicPlay.gameOverMusic();
                return true;
            }
        }
        return false;
    }

    /**
     * 英雄子弹射击到土墙
     * 因为英雄射击到土墙有声音， 所以不和敌方坦克射击到土墙方法共用
     */
    public static void heroBulletsHitWall(List<Bullet> bullets, List<BaseBuilding> walls) {
        boolean isHit = false;
        Iterator<Bullet> bIt = bullets.iterator();
        while (bIt.hasNext()) {
            Bullet b = bIt.next();
            Iterator<BaseBuilding> wIt = walls.iterator();
            while (wIt.hasNext()) {
                BaseBuilding wall = wIt.next();
                if (wall.isHit(b)) {
                    MusicPlay.brickEraseMusic();
                    //java.lang.IllegalStateException 无效状态异常。
                    //一般来说无效状态异常是因为你弄错了调用一个方法的流程
                    wIt.remove();
                    isHit = true;
                }
            }
            if (isHit) {
                bIt.remove();
                isHit = false;
            }
            // 两个不同类型集合remove方法写一起回报上面注释错误，故这是解决方案之一
        }
    }
    
    /**
     * 子弹射击到土墙
     */
    public static void bulletsHitWall(List<Bullet> bullets, List<BaseBuilding> walls) {
        boolean isHit = false;
        Iterator<Bullet> bIt = bullets.iterator();
        while (bIt.hasNext()) {
            Bullet b = bIt.next();
            Iterator<BaseBuilding> wIt = walls.iterator();
            while (wIt.hasNext()) {
                BaseBuilding wall = wIt.next();
                if (wall.isHit(b)) {
                    //java.lang.IllegalStateException 无效状态异常。
                    //一般来说无效状态异常是因为你弄错了调用一个方法的流程
                    wIt.remove();
                    isHit = true;
                }
            }
            if (isHit) {
                bIt.remove();
                isHit = false;
            }
            // 两个不同类型集合remove方法写一起回报上面注释错误，故这是解决方案之一
        }
    }
    
    /**
     * 我方坦克子弹射击到石墙
     */
    public static void heroBulletHitSteel(List<Bullet> heroBullets, List<BaseBuilding> steels, List<Explode> explodes) {
        boolean isHit = false;
        Iterator<BaseBuilding> it = steels.iterator();
        while (it.hasNext()) {
            BaseBuilding building = it.next();
            Iterator<Bullet> hbIt = heroBullets.iterator();
            while (hbIt.hasNext()) {
                Bullet b = hbIt.next();
                if (building.isHit(b)) {
                    hbIt.remove();
                    MusicPlay.hitMusic();
                    explodes.add(new Explode(b));
                    isHit = true;
                }
            }
            if (isHit && heroBullets.size() > 1) {
                it.remove();
                isHit = false;
            }
        }
    }
    
    /**
     * 敌方坦克射击到石墙
     */
    public static void enemyBulletHitSteel(List<Bullet> enemyBullets, List<BaseBuilding> steels) {
        for (BaseBuilding building : steels) {
            enemyBullets.removeIf(building::isHit);
        }
    }
    
    
    
    /******************************以下是knockAction里面需要调用的方法*************************************/

    /**
     * 英雄坦克碰到墙、河
     * 10ms走一次
     */
    public static void heroKnockBuildings(HeroTank hero, List<BaseBuilding> buildings) {
        for (BaseBuilding building : buildings) {
            if (building.isKnocked(hero)) {
                hero.returnToOldPoint();
            }
        }
    }
    
    /**
     * 敌方坦克撞墙、河
     */
    public static void enemyKnockBuildings(List<EnemyTank> enemys, List<BaseBuilding> buildings) {
        for (BaseBuilding building : buildings) {
            for (EnemyTank tank : enemys) {
                if (building.isKnocked(tank)) {
                    tank.returnToOldPoint();
                }
            }
        }
    }
    
    /**
     * 敌方坦克撞到敌方坦克
     */
    public static void enemyKnockEnemy(List<EnemyTank> tanks) {
        for (int i = 0; i < tanks.size() - 1; i++) {
            EnemyTank tank1 = tanks.get(i);
            for (int j = i + 1; j < tanks.size(); j++) {
                EnemyTank tank2 = tanks.get(j);
                if (tank1.isKnocked(tank2)) {
                    tank1.returnToOldPoint();
                }
            }
        }
    }
    
    /**
     * 敌方坦克撞到玩家
     */
    public static void enemyKnockHero(List<EnemyTank> tanks, HeroTank hero) {
        for (EnemyTank tank : tanks) {
            if (tank.isKnocked(hero)) {
                tank.returnToOldPoint();
            }
        }
    }
    
    /**
     * 玩家撞到敌方坦克
     */
    public static void heroKnockEnemy(HeroTank hero, List<EnemyTank> tanks) {
        for (EnemyTank tank : tanks) {
            if (tank.isKnocked(hero)) {
                hero.returnToOldPoint();
            }
        }
    }
    
    /**
     * 两玩家相撞
     */
    public static void heroKnockHero(HeroTank tank1, HeroTank tank2) {
        if (tank1.isKnocked(tank2)) {
            tank1.returnToOldPoint();
            tank2.returnToOldPoint();
        }
    }
    
}















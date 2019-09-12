package tank.main.bean;

import tank.map.BaseBuilding;
import tank.map.Home;

import java.util.List;

/**
 * 需要传递给Paint类的参数封装
 *
 * @author henengqiang
 * @date 2019/09/12
 */
public class PaintObjs {

    /**
     * 选择
     */
    private SelectTank selectTank;

    /**
     * 玩家
     */
    private HeroTank heroTank;
    private HeroTank hero2;
    private List<Bullet> heroBullets;
    private List<Bullet> heroBullets2;

    /**
     * 敌人
     */
    private List<EnemyTank> tanks;
    private List<Bullet> enemyBullets;

    /**
     * 爆炸和奖励
     */
    private List<Explode> explodes;
    private List<Award> awards;

    /**
     * 地图建材对象
     */
    private Home home;
    private List<BaseBuilding> walls;
    private List<BaseBuilding> steels;
    private List<BaseBuilding> grass;
    private List<BaseBuilding> rivers;

    public PaintObjs() {}

    public PaintObjs(SelectTank selectTank, HeroTank heroTank, HeroTank hero2, List<Bullet> heroBullets, List<Bullet> heroBullets2, List<EnemyTank> tanks, List<Bullet> enemyBullets, List<Explode> explodes, List<Award> awards, Home home, List<BaseBuilding> walls, List<BaseBuilding> steels, List<BaseBuilding> grass, List<BaseBuilding> rivers) {
        this.selectTank = selectTank;
        this.heroTank = heroTank;
        this.hero2 = hero2;
        this.heroBullets = heroBullets;
        this.heroBullets2 = heroBullets2;
        this.tanks = tanks;
        this.enemyBullets = enemyBullets;
        this.explodes = explodes;
        this.awards = awards;
        this.home = home;
        this.walls = walls;
        this.steels = steels;
        this.grass = grass;
        this.rivers = rivers;
    }

    public SelectTank getSelectTank() {
        return selectTank;
    }

    public void setSelectTank(SelectTank selectTank) {
        this.selectTank = selectTank;
    }

    public HeroTank getHeroTank() {
        return heroTank;
    }

    public void setHeroTank(HeroTank heroTank) {
        this.heroTank = heroTank;
    }

    public HeroTank getHero2() {
        return hero2;
    }

    public void setHero2(HeroTank hero2) {
        this.hero2 = hero2;
    }

    public List<Bullet> getHeroBullets() {
        return heroBullets;
    }

    public void setHeroBullets(List<Bullet> heroBullets) {
        this.heroBullets = heroBullets;
    }

    public List<Bullet> getHeroBullets2() {
        return heroBullets2;
    }

    public void setHeroBullets2(List<Bullet> heroBullets2) {
        this.heroBullets2 = heroBullets2;
    }

    public List<EnemyTank> getTanks() {
        return tanks;
    }

    public void setTanks(List<EnemyTank> tanks) {
        this.tanks = tanks;
    }

    public List<Bullet> getEnemyBullets() {
        return enemyBullets;
    }

    public void setEnemyBullets(List<Bullet> enemyBullets) {
        this.enemyBullets = enemyBullets;
    }

    public List<Explode> getExplodes() {
        return explodes;
    }

    public void setExplodes(List<Explode> explodes) {
        this.explodes = explodes;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public List<BaseBuilding> getWalls() {
        return walls;
    }

    public void setWalls(List<BaseBuilding> walls) {
        this.walls = walls;
    }

    public List<BaseBuilding> getSteels() {
        return steels;
    }

    public void setSteels(List<BaseBuilding> steels) {
        this.steels = steels;
    }

    public List<BaseBuilding> getGrass() {
        return grass;
    }

    public void setGrass(List<BaseBuilding> grass) {
        this.grass = grass;
    }

    public List<BaseBuilding> getRivers() {
        return rivers;
    }

    public void setRivers(List<BaseBuilding> rivers) {
        this.rivers = rivers;
    }

    @Override
    public String toString() {
        return "PaintObjs{" +
                "selectTank=" + selectTank +
                ", heroTank=" + heroTank +
                ", hero2=" + hero2 +
                ", heroBullets=" + heroBullets +
                ", heroBullets2=" + heroBullets2 +
                ", tanks=" + tanks +
                ", enemyBullets=" + enemyBullets +
                ", explodes=" + explodes +
                ", awards=" + awards +
                ", home=" + home +
                ", walls=" + walls +
                ", steels=" + steels +
                ", grass=" + grass +
                ", rivers=" + rivers +
                '}';
    }
}

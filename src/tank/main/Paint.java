package tank.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

import tank.main.bean.*;
import tank.main.gameresource.Img;
import tank.map.BaseBuilding;
import tank.map.Home;

import static tank.main.consts.Constants.HEIGHT;
import static tank.main.consts.Constants.WIDTH;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class Paint {

    private SelectTank selectTank;
    private HeroTank heroTank;
    private HeroTank hero2;
    private List<Bullet> heroBullets;
    private List<Bullet> heroBullets2;
    
    private List<EnemyTank> tanks;
    private List<Bullet> enemyBullets;
    private List<Explode> explodes;
    private List<Award> awards;
    
    private Home home;
    private List<BaseBuilding> walls;
    private List<BaseBuilding> steels;
    private List<BaseBuilding> grass;
    private List<BaseBuilding> rivers;

    public Paint(PaintObjs p) {
        this.selectTank = p.getSelectTank();
        this.heroTank = p.getHeroTank();

        this.heroBullets = p.getHeroBullets();
        this.tanks = p.getTanks();
        this.enemyBullets = p.getEnemyBullets();
        this.explodes = p.getExplodes();
        this.awards = p.getAwards();
        
        this.hero2 = p.getHero2();
        this.heroBullets2 = p.getHeroBullets2();
        
        this.home = p.getHome();
        this.walls = p.getWalls();
        this.steels = p.getSteels();
        this.grass = p.getGrass();
        this.rivers = p.getRivers();
    }
    
    public void paintLevel(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑", Font.BOLD, 100));
        g.drawString("LEVEL" + " " + (GameState.getLevel() + 1), (WIDTH - 450) / 2, (HEIGHT - 100) / 2);
    }
    
    public void paintStart(Graphics g) {
        g.drawImage(Img.title, (WIDTH - Img.title.getWidth()) / 2, 100, null);
        g.drawImage(Img.options, (WIDTH - Img.options.getWidth()) / 2, 450, null);
        g.drawImage(selectTank.getImage(), selectTank.getX(), selectTank.getY(), null);
    }
    
    public void paintSelectTank(Graphics g) {
        g.drawImage(selectTank.getImage(), selectTank.getX(), selectTank.getY(), null);
    }
    
    public void paintPause(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑", Font.BOLD, 50));
        g.drawString("PAUSE", (WIDTH - 150) / 2, (HEIGHT - 80) / 2);
    }
    
    public void paintOver(Graphics g) {
        g.drawImage(Img.gameOver, GameState.getOverX(), GameState.getOverY(), null);
    }
    
    private void paintHero(Graphics g) {
        g.drawImage(heroTank.getImage(), heroTank.getX() + (60 - 54) / 5, heroTank.getY() + 5, 50, 50, null);
    }
    private void paintHero2(Graphics g) {
        g.drawImage(hero2.getImage(), hero2.getX() + 5, hero2.getY() + 5, 50, 50, null);
    }
    
    private void paintHeroBullets(Graphics g) {
        for (Bullet b : heroBullets) {
            g.drawImage(b.getImage(), b.getX(), b.getY(), null);
        }
    }
    private void paintHeroBullets2(Graphics g) {
        for (Bullet b : heroBullets2) {
            g.drawImage(b.getImage(), b.getX(), b.getY(), null);
        }
    }
    
    
    private void paintEnemyTanks(Graphics g) {
        for (EnemyTank e : tanks) {
            g.drawImage(e.getImage(), e.getX(), e.getY(), null);
        }
    }
    
    private void paintEnemyBullets(Graphics g) {
        Iterator<Bullet> it = enemyBullets.iterator();
        while (it.hasNext()) {
            Bullet b = it.next();
            if (b.outOfBounds(new EnemyTank())) {
                it.remove();
            }
            g.drawImage(b.getImage(), b.getX(), b.getY(), null);
        }
    }
    
    private void paintExplodes(Graphics g) {
        Iterator<Explode> it = explodes.iterator();
        while (it.hasNext()) {
            Explode e = it.next();
            for (int j = 0; j < e.getImages().length; j++) {
                if (!e.blastDone()) {
                    g.drawImage(e.getImage(), e.getX(), e.getY(), null);
                }
            }
            if (e.blastDone()) {
                it.remove();
            }
        }
    }
    
    private void paintAward(Graphics g) {
        for (Award a : awards) {
            g.drawImage(a.getImage(), a.getX(), a.getY(), null);
        }
    }
    
    private void paintEnemyNum(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        g.drawString("Level:" + " " + GameState.getLevel() +  " " +
                "LeftEnemy:" + " " + GameState.getEnemyNum2(),
                (WIDTH - 150) / 2, 15);
    }
    
    private void paintHeroLife(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Player1:", 5, HEIGHT / 2 - 80);
        g.drawString("Life:" + heroTank.getLifeNum(), 5, HEIGHT / 2 - 45);
        if (heroTank.getBlood() <= 1) {
            g.fillRect(5, HEIGHT / 2 - 70, heroTank.getBlood() * 10, 5);
        } else if (heroTank.getBlood() > 1) {
            g.setColor(Color.GREEN);
            g.fillRect(5, HEIGHT / 2 - 70, heroTank.getBlood() * 10, 5);
        }
        // 画血条边框
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));
        g2.setColor(Color.BLUE);
        g2.drawRect(4, HEIGHT / 2 - 70 - 1, 3 * 10 + 2, 5 + 2);
    }
    private void paintHero2Life(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        g.drawString("Player2:", WIDTH - 75, HEIGHT / 2 - 80);
        g.drawString("Life:" + hero2.getLifeNum(), WIDTH - 75, HEIGHT / 2 - 45);
        if (hero2.getBlood() <= 1) {
            // 血量小于3时画红色
            g.fillRect(WIDTH - 75, HEIGHT / 2 - 70, hero2.getBlood() * 10, 5);
        } else if (hero2.getBlood() > 1) {
            // 血量健康时画绿色
            g.setColor(Color.GREEN);
            g.fillRect(WIDTH - 75, HEIGHT / 2 - 70, hero2.getBlood() * 10, 5);
        }
        // 画血条边框
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));
        g2.setColor(Color.BLUE);
        g2.drawRect(WIDTH - 75 - 1, HEIGHT / 2 - 70 - 1, 3 * 10 + 2, 5 + 2);
    }
    
    private void paintHome(Graphics g) {
        g.drawImage(home.getImage(), home.getX(), home.getY(), null);
    }
    
    private void paintMap(Graphics g) {
        for (BaseBuilding wall : walls) {
            g.drawImage(wall.getImage(), wall.getX(), wall.getY(), null);
        }
        for (BaseBuilding steel : steels) {
            g.drawImage(steel.getImage(), steel.getX(), steel.getY(), null);
        }
        for (BaseBuilding river : rivers) {
            g.drawImage(river.getImage(), river.getX(), river.getY(), null);
        }
    }

    /**
     * 把画草地单独拿出来是因为 画草地要在画了坦克之后画，要能遮住坦克
     */
    private void paintGrass(Graphics g) {
        for (BaseBuilding gra : grass) {
            g.drawImage(gra.getImage(), gra.getX(), gra.getY(), null);
        }
    }

    /**
     * 10ms 走一次
     */
    public void paintRunning(Graphics g) {
        paintMap(g);
        paintHero(g);
        paintEnemyTanks(g);
        paintEnemyBullets(g);
        if (!GameState.isIsOver1()) {
            paintHeroBullets(g);
            paintHeroLife(g);
        }
        if (selectTank.isTwoPlayers()) {
            paintHero2(g);
            if (!GameState.isIsOver2()){
                paintHeroBullets2(g);
                paintHero2Life(g);
            }
        }
        if (GameState.getState() != GameState.getOVER()) {
            paintHome(g);
        }
        paintGrass(g);
        paintExplodes(g);
        paintAward(g);
        paintEnemyNum(g);
    }   
    
    
}

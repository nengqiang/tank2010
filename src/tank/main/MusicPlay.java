package tank.main;

import tank.main.gameresource.Bgm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author henengqiang
 * @date 2019-09-05
 */
public class MusicPlay {
    
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(  
            40, 50,  
            1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10, false),
            new ThreadPoolExecutor.CallerRunsPolicy()  
    );  
    
    public static void startMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.start.play());
    }

    public static void addMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.add.play());
    }
    
    public static void fireMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.fire.play());
    }
    
    public static void hitMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.hit.play());
    }
    
    public static void blastMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.blast.play());
    }
    
    public static void brickEraseMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.brickErase.play());
    }
    
    public static void heroBlastMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.heroBlast.play());
    }
    
    public static void moveMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.move.play());
    }
    
    public static void gameOverMusic() {
        allowTimeOut();
        threadPool.execute(() -> Bgm.gameOver.play());
    }

    private static void allowTimeOut() {
        // 线程的最大空闲时间，超出这个时间将进行回收
        threadPool.allowCoreThreadTimeOut(true);
    }

}

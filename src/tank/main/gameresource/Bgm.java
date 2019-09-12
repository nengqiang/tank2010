package tank.main.gameresource;

import javax.swing.*;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

/**
 * @author henengqiang
 * @date 2019/09/03
 */
public class Bgm {

    public static AudioClip start;
    public static AudioClip add;
    public static AudioClip fire;
    public static AudioClip hit;
    public static AudioClip blast;
    public static AudioClip brickErase;
    public static AudioClip heroBlast;
    public static AudioClip move;
    public static AudioClip gameOver;

    /*
     * 用静态代码块初始化音频资源
     */
    static {
        try {
            start = JApplet.newAudioClip(getBgmUrl("start.wav"));
            add = JApplet.newAudioClip(getBgmUrl("add.wav"));
            fire = JApplet.newAudioClip(getBgmUrl("fire.wav"));
            hit = JApplet.newAudioClip(getBgmUrl("hit.wav"));
            blast = JApplet.newAudioClip(getBgmUrl("blast.wav"));
            brickErase = JApplet.newAudioClip(getBgmUrl("brickErase.wav"));
            heroBlast = JApplet.newAudioClip(getBgmUrl("buh.wav"));
            move = JApplet.newAudioClip(getBgmUrl("playermove.wav"));
            gameOver = JApplet.newAudioClip(getBgmUrl("gameOver.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static URL getBgmUrl(String bgmName) {
        try {
            return Bgm.class.getResource("bgm" + File.separator + bgmName);
        } catch (Exception e) {
            System.out.println(bgmName + "音频资源读取失败！");
            e.printStackTrace();
        }
        return null;
    }

}

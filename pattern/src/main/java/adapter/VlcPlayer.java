package adapter;

/**
 * Created by chenhao.ye on 25/01/2018.
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void mp4Play(String fileName) {

    }

    @Override
    public void vlcPlay(String fileName) {
        System.out.println("i am vlc player");
    }
}

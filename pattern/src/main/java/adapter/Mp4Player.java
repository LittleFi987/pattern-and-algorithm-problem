package adapter;

/**
 * Created by chenhao.ye on 25/01/2018.
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void mp4Play(String fileName) {
        System.out.println("Playing mp4 file. Name");
    }

    @Override
    public void vlcPlay(String fileName) {

    }
}

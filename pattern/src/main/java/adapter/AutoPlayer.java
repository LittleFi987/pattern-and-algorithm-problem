package adapter;

/**
 * Created by chenhao.ye on 25/01/2018.
 */
public class AutoPlayer implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equals("mp4")) {
            advancedMediaPlayer = new Mp4Player();
            advancedMediaPlayer.mp4Play("name");
        }

        if (audioType.equals("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
            advancedMediaPlayer.vlcPlay("vlc");
        }
    }

    public static void main(String[] args) {
        AutoPlayer autoPlayer = new AutoPlayer();
        autoPlayer.play("mp4", "dfs");
    }
}

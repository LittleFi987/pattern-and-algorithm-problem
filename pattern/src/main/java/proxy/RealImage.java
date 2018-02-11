package proxy;

/**
 * Created by chenhao.ye on 11/02/2018.
 */
public class RealImage implements Image {
    @Override
    public void play() {
        System.out.println("i am really image");
    }
}

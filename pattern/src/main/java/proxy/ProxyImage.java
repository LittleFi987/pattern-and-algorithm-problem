package proxy;

/**
 * Created by chenhao.ye on 11/02/2018.
 */
public class ProxyImage implements Image {

    private RealImage realImage;



    @Override
    public void play() {
        if (realImage == null) {
            realImage = new RealImage();
        }
        realImage.play();
    }
}

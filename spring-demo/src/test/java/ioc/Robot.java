package ioc;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class Robot {

    private Hand hand;

    private Mouth mouth;

    public void show(){

        hand.waveHand();
        mouth.speak();

    }

}

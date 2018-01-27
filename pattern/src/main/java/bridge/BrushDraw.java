package bridge;

/**
 * Created by chenhao.ye on 27/01/2018.
 */
public class BrushDraw implements Draw {

    private int x;

    private int y;


    @Override
    public void drawCircle(int x, int y) {
        System.out.println("i am brushDraw");
    }
}

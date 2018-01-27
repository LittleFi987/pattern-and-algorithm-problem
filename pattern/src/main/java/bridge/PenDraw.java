package bridge;

/**
 * Created by chenhao.ye on 27/01/2018.
 */
public class PenDraw implements Draw {

    private int x;

    private int y;

    public PenDraw(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void drawCircle(int x, int y) {
        System.out.println("pen draw");
    }
}

package bridge;

/**
 * Created by chenhao.ye on 27/01/2018.
 */
public abstract class Shape {

    private int x;

    private int y;

    private Draw draw;

    public Shape(int x, int y, Draw draw) {
        this.x = x;
        this.y = y;
        this.draw = draw;
    }


    public abstract void draw();

}

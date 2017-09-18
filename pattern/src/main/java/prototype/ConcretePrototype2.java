package prototype;

/**
 * Created by chenhaoye on 2017/8/13.
 */
public class ConcretePrototype2 implements Prototype {
    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}

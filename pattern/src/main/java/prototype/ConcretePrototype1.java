package prototype;

/**
 * Created by chenhaoye on 2017/8/13.
 */
public class ConcretePrototype1 implements Prototype {

    private String name;

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype1();
        return prototype;
    }

}

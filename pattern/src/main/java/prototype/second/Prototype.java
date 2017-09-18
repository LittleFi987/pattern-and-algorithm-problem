package prototype.second;

/**
 * Created by chenhaoye on 2017/8/13.
 */
public interface Prototype {

    Prototype clone();

    String getName();

    void setName(String name);

}

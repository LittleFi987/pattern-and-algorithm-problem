package prototype;

/**
 * Created by chenhaoye on 2017/8/13.
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public void operation(Prototype example){
        Prototype copyPrototype = prototype.clone();
    }



}

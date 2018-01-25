package spring.ioc.util;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class ClassUtils {

    public static ClassLoader getDefultClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class loadClass(String className){
        try {
            return getDefultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


}

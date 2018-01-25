package spring.ioc.util;

import java.lang.reflect.Field;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class ReflectionUtils {
    public static void injectField(Field field, Object obj, Object value) throws IllegalAccessException {
        if(field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }
}

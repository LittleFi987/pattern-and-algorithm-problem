package spring.ioc.core;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}

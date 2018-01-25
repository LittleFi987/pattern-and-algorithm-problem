package spring.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by chenhao.ye on 14/01/2018.
 */
@Data
@ToString
public class BeanDefinition {

    private String name;

    private String className;

    private String interfaceName;

    private List<ConstructorArg> constructorArgs;

    private List<PropertyArg> propertyArgs;

}

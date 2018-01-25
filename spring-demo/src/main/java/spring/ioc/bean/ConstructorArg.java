package spring.ioc.bean;

import lombok.Data;
import lombok.ToString;

/**
 * Created by chenhao.ye on 14/01/2018.
 */
@Data
@ToString
public class ConstructorArg {

    private int index;

    private String ref;

    private String name;

}

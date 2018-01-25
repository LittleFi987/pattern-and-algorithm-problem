package ioc.test;

import ioc.Robot;
import spring.ioc.core.JsonApplicationContext;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot aiRobot = (Robot) applicationContext.getBean("robot");

        aiRobot.show();
    }

}

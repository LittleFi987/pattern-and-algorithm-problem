package spring.ioc.core;

import com.fasterxml.jackson.core.type.TypeReference;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.util.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class JsonApplicationContext extends BeanFactoryImpl {
    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is, new TypeReference<List<BeanDefinition>>() {
        });

        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }

    }


}

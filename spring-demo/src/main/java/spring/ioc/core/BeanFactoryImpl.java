package spring.ioc.core;

import org.apache.commons.lang3.StringUtils;
import spring.ioc.bean.BeanDefinition;
import spring.ioc.bean.ConstructorArg;
import spring.ioc.util.BeanUtils;
import spring.ioc.util.ClassUtils;
import spring.ioc.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chenhao.ye on 15/01/2018.
 */
public class BeanFactoryImpl implements BeanFactory {

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());


    @Override
    public Object getBean(String name) throws Exception {
        // 查找对象是否已经实例化
        Object bean = beanMap.get(name);

        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = beanDefineMap.get(name);

        bean = createBean(beanDefinition);

        if (bean != null) {
            //对象创建成功以后，注入对象需要的参数
            populatebean(bean);

            //再吧对象存入Map中方便下次使用。
            beanMap.put(name, bean);
        }

        return bean;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String beanName = beanDefinition.getClassName();
        Class clz = ClassUtils.loadClass(beanName);
        if (clz == null) {
            throw new Exception("can not find bean by beanName");
        }
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                objects.add(getBean(constructorArg.getRef()));
            }
            return BeanUtils.instanceByCglib(clz, clz.getConstructor(), objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
    }

    protected void registerBean(String name, BeanDefinition bd) {
        beanDefineMap.put(name, bd);
        beanNameSet.add(name);
    }

    private void populatebean(Object bean) throws Exception {
        Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                if (beanNameSet.contains(field.getName())) {
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null) {
                        ReflectionUtils.injectField(field, bean, fieldBean);
                    }
                }
            }
        }
    }


}

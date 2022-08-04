package com.example.learn.spring.dependency;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ObjectFactory
 * @Description: 对象工厂
 * @Author: kotchen
 * @Date: 2021/4/23 10:20
 * @Version: 1.0
 **/
interface ObjectFactory<T> {
    /**
     * 获取对象
     *
     * @return
     */
    T getObject();
}

/**
 * @ClassName: DependencyDemo
 * @Description: Spring 循环依赖
 * @Author: kotchen
 * @Date: 2021/4/23 10:20
 * @Version: 1.0
 **/
public class DependencyDemo {

    /**
     * 初始化完毕的Bean(一级缓存)
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    /**
     * 正在初始化的Bean对应的工厂，此时对象已经被实例化(三级缓存)
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    /**
     * 存放正在初始化的Bean，对象还没有被实例化之前就放进来了
     */
    private final Set<String> singletonsCurrentlyInCreation = Collections.newSetFromMap(new ConcurrentHashMap<>(16));

    public <T> T getBean(Class<T> beanClass) throws Exception {
        // 类名为Bean的名字
        String beanName = beanClass.getSimpleName();

        // 已经初始化好了，或者正在初始化
        Object initObj = getSingleton(beanName, true);
        if (initObj != null) {
            return (T) initObj;
        }

        // bean正在被初始化
        singletonsCurrentlyInCreation.add(beanName);

        // 实例化bean
        Object object = beanClass.getDeclaredConstructor().newInstance();
        singletonFactories.put(beanName, () -> object);

        // 开始初始化bean，即填充属性
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取需要注入字段的class
            Class<?> fieldClass = field.getType();
            field.set(object, getBean(fieldClass));
        }

        // 初始化完毕
        singletonObjects.put(beanName, object);
        singletonsCurrentlyInCreation.remove(beanName);

        return (T) object;
    }

    /**
     * allowEarlyReference参数的含义是Spring是否允许循环依赖，默认为true
     * 所以当allowEarlyReference设置为false的时候，当项目存在循环依赖，会启动失败
     */
    public Object getSingleton(String beanName, boolean allowEarlyReference) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            synchronized (this.singletonObjects) {
                if (singletonObject == null && allowEarlyReference) {
                    ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        singletonObject = singletonFactory.getObject();
                    }
                }
            }
        }

        return singletonObject;
    }

    /**
     * 判断bean是否正在被初始化
     */
    public boolean isSingletonCurrentlyInCreation(String beanName) {
        return this.singletonsCurrentlyInCreation.contains(beanName);
    }

    public static void main(String[] args) throws Exception {
        DependencyDemo dependencyDemo = new DependencyDemo();

        // 假装扫描出来的对象
        Class[] classes = {A.class, B.class};

        // 假装项目初始化所有bean
        for (Class aClass : classes) {
            dependencyDemo.getBean(aClass);
        }

        // true
        System.out.println(dependencyDemo.getBean(B.class).getA() == dependencyDemo.getBean(A.class));

        // true
        System.out.println(dependencyDemo.getBean(A.class).getB() == dependencyDemo.getBean(B.class));
    }

}

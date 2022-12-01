package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @create: 2022-11-29 21:30
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}

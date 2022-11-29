package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.config.BeanDefinition;

/**
 * @version 1.0
 * @create: 2022-11-29 21:46
 * @author: L1Chenxv
 * @************
 * @description:
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //调用 addSingleton 方法存放到单例对象的缓存中去。
        addSingleton(beanName, bean);
        return bean;
    }
}

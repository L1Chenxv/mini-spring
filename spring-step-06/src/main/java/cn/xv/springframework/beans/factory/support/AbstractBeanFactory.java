package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.BeanFactory;
import cn.xv.springframework.beans.factory.config.BeanDefinition;
import cn.xv.springframework.beans.factory.config.BeanPostProcessor;
import cn.xv.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @create: 2022-11-29 21:35
 * @author: L1Chenxv
 * @************
 * @description:  负责得到 bean 实例
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}

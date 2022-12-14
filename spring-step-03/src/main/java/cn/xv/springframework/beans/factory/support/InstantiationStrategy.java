package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}

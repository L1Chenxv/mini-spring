package cn.xv.springframework.test.common;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.PropertyValue;
import cn.xv.springframework.beans.PropertyValues;
import cn.xv.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.xv.springframework.beans.factory.config.BeanDefinition;
import cn.xv.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @version 1.0
 * @create: 2022-12-11 20:36
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动 "));
    }
}

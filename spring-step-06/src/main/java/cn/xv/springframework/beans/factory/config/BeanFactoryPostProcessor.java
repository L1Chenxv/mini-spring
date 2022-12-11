package cn.xv.springframework.beans.factory.config;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws
            BeansException;
}

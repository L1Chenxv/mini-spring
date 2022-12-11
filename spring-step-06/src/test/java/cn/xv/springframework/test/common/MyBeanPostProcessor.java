package cn.xv.springframework.test.common;

import cn.xv.springframework.test.bean.UserService;
import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @version 1.0
 * @create: 2022-12-11 20:37
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

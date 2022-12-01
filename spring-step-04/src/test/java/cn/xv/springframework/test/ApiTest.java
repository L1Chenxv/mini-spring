package cn.xv.springframework.test;

import cn.xv.springframework.beans.PropertyValue;
import cn.xv.springframework.beans.PropertyValues;
import cn.xv.springframework.beans.factory.config.BeanDefinition;
import cn.xv.springframework.beans.factory.config.BeanReference;
import cn.xv.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xv.springframework.test.bean.UserDao;
import cn.xv.springframework.test.bean.UserService;
import org.junit.Test;

import java.io.InputStreamReader;

/**
 * @version 1.0
 * @create: 2022-11-30 21:44
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

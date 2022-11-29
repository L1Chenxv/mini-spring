package cn.xv.springframework.test;

import cn.xv.springframework.BeanDefinition;
import cn.xv.springframework.BeanFactory;
import cn.xv.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @version 1.0
 * @create: 2022-11-29 20:52
 * @author: L1Chenxv
 * @************
 * @description:
 */

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        BeanFactory beanFactory = new BeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

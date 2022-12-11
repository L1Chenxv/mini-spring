package cn.xv.springframework.context.support;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @version 1.0
 * @create: 2022-12-11 17:35
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException{
        this(new String[]{configLocations});
    }

    /**
     * 从XML 中加载 BeanDefinition, 并刷新上下文
     *
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }


    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}

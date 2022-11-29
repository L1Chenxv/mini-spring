package cn.xv.springframework;

/**
 * @version 1.0
 * @create: 2022-11-29 20:50
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}

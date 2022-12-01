package cn.xv.springframework.beans.factory.config;

/**
 * @version 1.0
 * @create: 2022-11-30 22:51
 * @author: L1Chenxv
 * @************
 * @description: Bean 的引用
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

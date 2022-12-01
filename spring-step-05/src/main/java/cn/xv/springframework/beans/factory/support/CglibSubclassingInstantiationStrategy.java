package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @version 1.0
 * @create: 2022-11-30 21:20
 * @author: L1Chenxv
 * @************
 * @description: Cglib代理策略
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}

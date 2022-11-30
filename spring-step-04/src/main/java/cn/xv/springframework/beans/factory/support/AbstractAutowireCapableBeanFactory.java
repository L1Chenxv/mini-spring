package cn.xv.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.xv.springframework.beans.BeansException;
import cn.xv.springframework.beans.PropertyValue;
import cn.xv.springframework.beans.PropertyValues;
import cn.xv.springframework.beans.factory.config.BeanDefinition;
import cn.xv.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @version 1.0
 * @create: 2022-11-29 21:46
 * @author: L1Chenxv
 * @************
 * @description: 负责创造bean实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);

            // 填充bean实例属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //调用 addSingleton 方法存放到单例对象的缓存中去。
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * Bean 属性填充
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    //A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    /**
     * Bean 实例创建
     *
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterCount() == args.length) {
                constructorToUse = ctor;
                break;
            }
        }

        //调用实例化策略生成实例bean
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}

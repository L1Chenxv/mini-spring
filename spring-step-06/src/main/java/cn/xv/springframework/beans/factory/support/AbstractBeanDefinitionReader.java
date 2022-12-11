package cn.xv.springframework.beans.factory.support;

import cn.xv.springframework.core.io.DefaultResourceLoader;
import cn.xv.springframework.core.io.ResourceLoader;

/**
 * @version 1.0
 * @create: 2022-12-01 20:46
 * @author: L1Chenxv
 * @************
 * @description:
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

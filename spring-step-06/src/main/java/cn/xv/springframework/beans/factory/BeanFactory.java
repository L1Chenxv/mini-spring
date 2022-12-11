package cn.xv.springframework.beans.factory;

import cn.xv.springframework.beans.BeansException;

/**
 * @version 1.0
 * @create: 2022-11-29 21:27
 * @author: L1Chenxv
 * @************
 * @description:
 */
public interface BeanFactory {
   Object getBean(String name) throws BeansException;

   Object getBean(String name, Object...args) throws BeansException;

   public <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}

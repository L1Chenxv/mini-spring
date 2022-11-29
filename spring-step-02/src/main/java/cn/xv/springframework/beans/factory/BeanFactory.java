package cn.xv.springframework.beans.factory;

/**
 * @version 1.0
 * @create: 2022-11-29 21:27
 * @author: L1Chenxv
 * @************
 * @description:
 */
public interface BeanFactory {
   Object getBean(String name);
}

package cn.xv.springframework.beans;

/**
 * @version 1.0
 * @create: 2022-11-29 21:24
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class BeansException extends RuntimeException{
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}

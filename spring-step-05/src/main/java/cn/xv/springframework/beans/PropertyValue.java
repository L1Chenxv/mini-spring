package cn.xv.springframework.beans;

import lombok.Data;

/**
 * @version 1.0
 * @create: 2022-11-30 22:36
 * @author: L1Chenxv
 * @************
 * @description: 定义属性
 */
@Data
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}

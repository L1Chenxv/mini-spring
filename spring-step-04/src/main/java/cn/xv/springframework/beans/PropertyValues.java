package cn.xv.springframework.beans;

import cn.xv.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @create: 2022-11-30 22:40
 * @author: L1Chenxv
 * @************
 * @description:
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}

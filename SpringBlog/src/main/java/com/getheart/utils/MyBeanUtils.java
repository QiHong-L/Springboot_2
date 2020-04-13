package com.getheart.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Json
 * @date 2020-02-14:42
 */
public class MyBeanUtils {

    public static String[] getNullPropertyNames(Object source){

        BeanWrapper bw = new BeanWrapperImpl(source);
        PropertyDescriptor[] ps = bw.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd : ps) {
            String propertyName = pd.getName();
            if(bw.getPropertyValue(propertyName) == null){
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
}

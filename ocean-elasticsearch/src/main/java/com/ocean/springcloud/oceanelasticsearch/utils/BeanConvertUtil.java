package com.ocean.springcloud.oceanelasticsearch.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chao
 * @description:
 * @create: 2020-12-06 14:06
 */
public class BeanConvertUtil {
    private static final Logger log = LoggerFactory.getLogger(BeanConvertUtil.class);
    private BeanConvertUtil(){}
    /**
     * 实体复制
     *
     * @param object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copyOf(Object object, Class<T> clazz) {
        T result = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(object, result);
        return result;
    }

    /**
     * List复制
     *
     * @param list  原list
     * @param clazz 目标list存放实体
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T, E> List<E> copyOf(List<T> list, Class<E> clazz) {
        List<E> result = new ArrayList<>();
        for (T t : list) {
            E ent = BeanUtils.instantiateClass(clazz);
            BeanUtils.copyProperties(t, ent);
            result.add(ent);
        }
        return result;
    }

    /**
     * map 转换成指定Bean
     *
     * @param map   map
     * @param clazz 类型
     * @param <T>   转换的类型
     * @return 结果集
     */
    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        String beanJson = JSON.toJSONString(map);
        return JSON.parseObject(beanJson, clazz);
    }

    /**
     * obj 转换map
     *
     * @param bean 要转换的bean
     * @return map
     */
    public static Map<String, Object> convert2Map(Object bean) {
        if (null == bean) {
            return null;
        }
        String srcJson = JSON.toJSONString(bean);
        return JSON.parseObject(srcJson, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * @param bean
     * @return Map<String, Object>    返回类型
     * @throws
     * @Title: bean2Map
     * @Description: bean转map 默认为null
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Map<String, Object> bean2Map(Object bean) {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; ++i) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!(propertyName.equals("class"))) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, null);
                    }
                }
            }
            return returnMap;
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            log.error("BEAN转换成MAP出现异常", e);
        }
        return null;
    }


    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap();
        if (obj == null) {
            return map;
        } else {
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            try {
                Field[] var4 = fields;
                int var5 = fields.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Field field = var4[var6];
                    field.setAccessible(true);
                    map.put(field.getName(), field.get(obj));
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }

            return map;
        }
    }

}

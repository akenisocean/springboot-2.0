package com.jk.di.dataflow.dataflowtransforms.utils;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @author chao
 * @description 集合工具类
 * @create 2021-01-05 11:04
 */
public final class CollectionUtils {

    private CollectionUtils() {
    }

    /**
     * 校验集合是否为空
     *
     * @param coll 入参
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    /**
     * 校验集合是否不为空
     *
     * @param coll 入参
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断Map是否为空
     *
     * @param map 入参
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 判断Map是否不为空
     *
     * @param map 入参
     * @return boolean
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }


    /**
     * Whether contain item in collection.
     *
     * @param coll   collection
     * @param target target value
     * @param <T>    Genreal Type
     * @return true if contain, otherwise false
     */
    public static <T> boolean contains(Collection<T> coll, T target) {
        if (isEmpty(coll)) {
            return false;
        }
        return coll.contains(target);
    }

    /**
     * Merge the given Properties instance into the given Map,
     * copying all properties (key-value pairs) over.
     * <p>Uses {@code Properties.propertyNames()} to even catch
     * default properties linked into the original Properties instance.
     * @param props the Properties instance to merge (may be {@code null})
     * @param map the target Map to merge the properties into
     */
    public static <K, V> void mergePropertiesIntoMap(Properties props, Map<K, V> map) {
        if (props != null) {
            for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                Object value = props.get(key);
                if (value == null) {
                    // Allow for defaults fallback or potentially overridden accessor...
                    value = props.getProperty(key);
                }
                map.put((K) key, (V) value);
            }
        }
    }
}

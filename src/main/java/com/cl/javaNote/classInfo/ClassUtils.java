package com.cl.javaNote.classInfo;

import com.cl.dataStructures.array.Array;
import com.sun.corba.se.spi.ior.IdentifiableFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * Created by cl on 2017/12/15.
 */
public class ClassUtils {
    public static void main(String[] args) throws IllegalAccessException {
        BasicClass basicClass = new BasicClass(1);
        BasicClass other = (BasicClass) new ClassUtils().inheritValue(BasicClass.class, basicClass);
        System.out.println(other);
    }

    /**
     * 获取该类的属性
     *
     * @param object
     * @return
     */
    public static Map<String, Object> getPropertiesAndValues(Object object) {
        Class<?> basicClass = object.getClass();
        Field[] fs = getDeclaredFields(basicClass);
        if (fs == null || fs.length < 1)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            if (f==null)
                continue;
            f.setAccessible(true); //设置些属性是可以访问的
            Object val = null;//得到此属性的值
            try {
                val = f.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (val != null)
                map.put(f.getName(), val);
        }
        return map;
    }

    static Field[] getDeclaredFields(Class<?> basicClass) {
        if (basicClass == null || basicClass.isInstance(Object.class)) {
            return new Field[0];
        }
        Field[] fields = basicClass.getDeclaredFields();
        if (fields == null || fields.length < 1)
            return getDeclaredFields(basicClass.getSuperclass());
        return mergeField(fields, getDeclaredFields(basicClass.getSuperclass()));
    }

    static Field[] mergeField(Field[] fields1, Field[] fields2) {
        if (fields1 != null || fields2 != null) {
            if (fields1 == null)
                return fields2;
            if (fields2 == null)
                return fields1;
            if (fields1.length > 0 || fields2.length > 0) {
                if (fields1.length < 1)
                    return fields2;
                if (fields2.length < 1)
                    return fields1;
                int length = fields1.length + fields2.length;
                Field[] fields = new Field[length];
                for (int i = 0; i < fields1.length; i++) {
                    fields[i] = fields1[i];
                }
                for (int i = 0; i < fields2.length; i++) {
                    fields[fields1.length+i] = fields2[i];
                }
                return fields;
            }
        }
        return new Field[0];
    }

    /**
     * 获取该类的属性
     *
     * @param object
     * @return
     */
    public static Set<String> getProperties(Object object) {
        Class<?> basicClass = object.getClass();
        Field[] fields = basicClass.getDeclaredFields();
        Set<String> strings = new HashSet<String>();
        for (Field field : fields) {
            strings.add(field.getName());
        }
        getProperties(basicClass, strings);
        return strings;
    }

    /**
     * 获取父类的属性字段
     *
     * @param basicClass
     * @param strings
     */
    public static void getProperties(Class<?> basicClass, Set<String> strings) {
        Class<?> externalClass = basicClass.getSuperclass();
        if (externalClass != null) {
            Field[] fields = basicClass.getDeclaredFields();
            Set<String> parentStrings = new HashSet<String>();
            for (Field field : fields) {
                parentStrings.add(field.getName());
            }
            if (parentStrings != null && parentStrings.size() > 0) {
                getProperties(externalClass, parentStrings);
                strings.addAll(parentStrings);
            }
        }
    }


    /**
     * 为某个类赋值
     *
     * @param object
     * @param map
     */
    public static Object setProperties(Object object, Map<String, Object> map) {
        Class<?> basicClass = object.getClass();
        Field field = null;
        for (String key : map.keySet()) {
            try {
                Object value = map.get(key);
                field = getField(basicClass, key);
                if (field != null) {
                    field.setAccessible(true); // 抑制Java对修饰符的检查
                    field.set(object, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    /**
     * 获取field
     * 若是继承关系 则从父类中查询
     *
     * @param basicClass
     * @param key
     * @return
     */
    static Field getField(Class<?> basicClass, String key) {
        Field field = null;
        try {
            field = basicClass.getDeclaredField(key);
        } catch (NoSuchFieldException e) {
            Class<?> parentClass = basicClass.getSuperclass();
            if (parentClass != null)
                field = getField(parentClass, key);
        }
        return field;
    }

    /**
     * 从beInherit复制值到inherit中
     *
     * @param inherit
     * @param beInherit
     * @return
     */
    public static Object inheritValue(Object inherit, Object beInherit) {
        Map<String, Object> map = new HashMap();
        Set<String> pro_inherit = getProperties(inherit);
        if (pro_inherit.size() > 0) {
            Map<String, Object> pro_beInherit = getPropertiesAndValues(beInherit);
            if (pro_beInherit != null && pro_beInherit.size() > 0) {
                for (String property : pro_inherit) {
                    if (pro_beInherit.get(property) != null) {
                        map.put(property, pro_beInherit.get(property));
                    }
                }
            }
        }
        if (map.size() > 0) {
            inherit = setProperties(inherit, map);
        }
        return inherit;
    }
}

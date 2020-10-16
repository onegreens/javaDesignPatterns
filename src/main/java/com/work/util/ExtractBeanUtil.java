package com.work.util;

import com.cl.javaNote.classInfo.ClassUtils;

import java.util.HashMap;
import java.util.Map;

public class ExtractBeanUtil {

    /**
     * 抽取对应的字段生成map
     *
     * @param obj
     * @param params
     * @return
     */
    public Map extract(Object obj, String[] params) {
        Map result = new HashMap();
        Map values = ClassUtils.getPropertiesAndValues(obj);

        if (params != null && params.length > 0) {
            for (String param : params) {
                if (values.get(param) != null) result.put(param, values.get(param));
            }
        }
        return result;
    }
}

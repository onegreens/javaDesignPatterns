package com.work.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cl on 2017/9/23.
 */
public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json string convert to map
     * json 字符串 转换为 map (Map<String, Object>)
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> json2map(String jsonStr)
            throws Exception {
        return objectMapper.readValue(jsonStr, Map.class);
    }

    public Map<String, Object> stringToMap(String str) {
        String str1 = str.replaceAll("\\{|\\}", "");//singInfo是一个map  toString后的字符串。
        String str2 = str1.replaceAll(" ", "");
        String str3 = str2.replaceAll(",", "&");


        Map<String, Object> map = null;
        if ((null != str3) && (!"".equals(str3.trim()))) {
            String[] resArray = str3.split("&");
            if (0 != resArray.length) {
                map = new HashMap(resArray.length);
                for (String arrayStr : resArray) {
                    if ((null != arrayStr) && (!"".equals(arrayStr.trim()))) {
                        int index = arrayStr.indexOf("=");
                        if (-1 != index) {
                            map.put(arrayStr.substring(0, index), arrayStr.substring(index + 1));
                        }
                    }
                }
            }
        }
        return map;
    }

}

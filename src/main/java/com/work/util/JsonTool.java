package com.work.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;
import java.util.*;

public class JsonTool {


    public static <T> Map<String, T> jsonToMapObject(String s, Class<T> clazz) {


        Map<String, JSONObject> map = (Map<String, JSONObject>) JSON.parse(s);
        Map<String, T> result = new HashMap();
        Iterator<String> keyIte = map.keySet().iterator();
        while (keyIte.hasNext()) {
            String key = keyIte.next();
            JSONObject obj = map.get(key);
            result.put(key, obj.toJavaObject(clazz));
        }
        return result;
    }
    public static  Map<String, Object> jsonToMap(String s) {
        Map<String, Object> map = (Map<String, Object>) JSON.parse(s);
        Map<String, Object> result = new HashMap();
        Iterator<String> keyIte = map.keySet().iterator();
        while (keyIte.hasNext()) {
            String key = keyIte.next();
            Object obj = map.get(key);
            if(obj instanceof JSONObject){
                result.put(key, obj.toString());
            }else{
                result.put(key, obj);
            }
        }
        return result;
    }

    public static <T> List<T> jsonToListObject(String s, Class<T> clazz) {
        List<JSONObject> map = (List<JSONObject>) JSON.parse(s);
        List<T> result = new ArrayList();
        Iterator<JSONObject> keyIte = map.iterator();
        while (keyIte.hasNext()) {

            JSONObject key = keyIte.next();
            result.add(key.toJavaObject(clazz));
        }
        return result;
    }

    public static String string2Json(String s) {
        StringBuilder sb = new StringBuilder(s.length() + 20);
        sb.append('\"');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    sb.append(c);
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String map2Json(Map<String, Object> map) {
        if (map.isEmpty())
            return "{}";
        StringBuilder sb = new StringBuilder(map.size() << 4);
        sb.append('{');
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Object value = map.get(key);
            sb.append('\"');
            sb.append(key);
            sb.append('\"');
            sb.append(':');
            sb.append(toJson(value));
            sb.append(',');
        }
        // 将最后的 ',' 变为 '}':
        sb.setCharAt(sb.length() - 1, '}');
        return sb.toString();
    }


    public static String array2Json(Object[] array) {
        if (array.length == 0)
            return "[]";
        StringBuilder sb = new StringBuilder(array.length << 4);
        sb.append('[');
        for (Object o : array) {
            sb.append(toJson(o));
            sb.append(',');
        }
        // 将最后添加的 ',' 变为 ']':
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String list2Json(List list) {
        if (list.size() == 0)
            return "[]";
        StringBuilder sb = new StringBuilder(list.size() << 4);
        sb.append('[');
        for (Object o : list) {
            sb.append(toJson(o));
            sb.append(',');
        }
        // 将最后添加的 ',' 变为 ']':
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String number2Json(Number number) {
        return number.toString();
    }

    public static String boolean2Json(Boolean bool) {
        return bool.toString();
    }

    public static String timestamp2Json(Timestamp time) {
        return "\"" + time.toString() + "\"";
    }


    public static String toJson(Object o) {
        if (o == null)
            return "null";
        if (o instanceof String)
            return string2Json((String) o);
        if (o instanceof Boolean)
            return boolean2Json((Boolean) o);
        if (o instanceof Number)
            return number2Json((Number) o);
        if (o instanceof Map)
            return map2Json((Map<String, Object>) o);
        if (o instanceof Object[])
            return array2Json((Object[]) o);
        if (o instanceof Timestamp) {
            return timestamp2Json((Timestamp) o);
        }
        if (o instanceof ArrayList) {
            return list2Json((ArrayList) o);
        }
        throw new RuntimeException("Unsupported type: " + o.getClass().getName());
    }


    public static void main(String[] args) {
        String s = "sssssssss";
        System.out.print(string2Json(s));

        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2Json(time));
    }
}

package com.cl.javaNote.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by cl on 2017/9/5.
 * 格式化集合
 */
public class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0)
            return "[]";
        StringBuffer result = new StringBuffer("[");
        for (Object item : c) {
            if (c.size() != 1)
                result.append("\n   ");
            result.append(item);
        }
        if (c.size() != 1)
            result.append("\n   ");
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}

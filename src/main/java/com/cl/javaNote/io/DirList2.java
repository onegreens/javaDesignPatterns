package com.cl.javaNote.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by cl on 2017/7/27.
 * 改写DirList
 * 通过匿名内部类的方式
 */
public class DirList2 {
    /**
     * 参数必须是final的。
     * 匿名内部类才能使用自该类范围之外的对象
     * @param regex
     * @return
     */
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(filter(args[0]));//类似策略模式 list会调用DirFilter中的accept方法
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

}

package com.cl.javaNote.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by cl on 2017/9/5.
 * 改进DirList2
 * 定义一个作为list()参数的匿名内部类
 */
public class DirList3 {
    public static void main(final String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(
                    new FilenameFilter() {
                        Pattern pattern = Pattern.compile(args[0]);
                        public boolean accept(File dir, String name) {
                            return pattern.matcher(name).matches();
                        }
                    });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}

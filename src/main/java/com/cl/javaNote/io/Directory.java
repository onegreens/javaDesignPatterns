package com.cl.javaNote.io;

import com.cl.javaNote.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by cl on 2017/9/5.
 * 目录实用工具
 * 作用：通过local()方法产生本地目录中的文件构成的File对象数组，
 * 或者通过使用walk()方法产生给定目录下的整个目录树中的所有文件构成的list<File>
 */
public class Directory {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> dirs = new ArrayList<File>();
        public List<File> files = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            dirs.addAll(other.dirs);
            files.addAll(other.files);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "dirs=" + PPrint.pformat(dirs) +
                    ", files=" + PPrint.pformat(files) +
                    '}';
        }
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else if (item.getName().matches(regex)) {
                result.files.add(item);
            }
        }
        return result;
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println(walk("."));
        else
            for (String str : args)
                System.out.println(walk(str));

    }
}

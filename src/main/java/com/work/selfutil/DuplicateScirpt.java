package com.work.selfutil;

import com.cl.javaNote.io.BufferedInputFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DuplicateScirpt {

    public static void main(String[] args) throws IOException {
        String path = "D:\\project\\SNMP\\SnmpOmcWebapp\\WebContent\\jsp\\topoNew\\topo_vml.js";
        List<File> files = readFile(new File(path));
        String path2 = "D:\\project\\SNMP\\SnmpOmcWebapp\\WebContent\\jsp\\topoNew\\topo_util.js";
        files.addAll(readFile(new File(path2)));
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            if (file.getName().endsWith(".js"))
                lists.addAll(BufferedInputFile.readToList(file));
        }
        List<String> result = new ArrayList<>();
        List<String> funs = new ArrayList<>();
        String lable = "function";
        for (int i = 0; i < lists.size(); i++) {
            String str = lists.get(i);
            if (str.startsWith(lable)) {
                String fun = str.substring(lable.length() + 1, str.indexOf("("));
                if (funs.contains(fun)) {

                    result.add(fun);
                } else {

                    funs.add(fun);
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + ":" + result.get(i));
        }
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println("=========================================================");
//        for (int i = 0; i < funs.size(); i++) {
//            System.out.println(i+":"+funs.get(i));
//        }

    }

    public static List<File> readFile(File file) {
        List<File> list = new ArrayList<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                list.addAll(readFile(files[i]));
            }
        } else {
            list.add(file);
        }
        return list;
    }


}

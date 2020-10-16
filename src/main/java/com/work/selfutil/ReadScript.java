package com.work.selfutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cl.javaNote.io.BufferedInputFile;
import com.work.util.JsonTool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadScript {

    public static void main(String[] args) throws IOException {
        String path = "E:\\scripts";
        File file = new File(path);

        List<File> lists = readFile(file);
        for (int i = 0; i < lists.size(); i++) {
            printFile(lists.get(i));
        }
    }

    public static void printFile(File file) {
        String str = null;
        try {
            str = BufferedInputFile.read(file);
            Map map = JSON.parseObject(str);

            String content = (String) map.get("content");


            //����һ����ָ���ļ����ӵ�FileWriter
            //Ϊ���ṩ��ʽ�����ƣ���ʹ��PrintWriter
            //�������ַ�ʽ�����������ļ�����������ͨ�ı��ļ���ȡ
            File outFile = new File(file.getParentFile().getPath() + File.separator + file.getName() + ".sql");
            if (!outFile.exists()) outFile.createNewFile();
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(outFile)));
            writer.write(content);
            //�����Ϊwriter����close()���򻺳������ݲ��ᱻˢ�����
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

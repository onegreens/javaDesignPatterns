package com.work.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cl on 2017/6/27.
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path="D:\\project\\ziptest\\zip\\out\\电信测试";
        List<Map<String,String>> list = readFile(path);
    }

    public static List<Map<String,String>>  readFile(String path) throws IOException {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        File file=new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数："+tempList.length);
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                System.out.println("文     件："+tempList[i]);
                list=readTxt(tempList[i],list);
            }
            if (tempList[i].isDirectory()) {
                System.out.println("文件夹："+tempList[i]);
            }
        }
        return list;

    }

    /**
     * 中文
     * @param file
     * @throws IOException
     */
    public static List<Map<String,String>> readTxt(File file,List<Map<String,String>> list) throws IOException {
        StringBuffer fileContent = new StringBuffer();
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"gbk");
        BufferedReader reader=new BufferedReader(read);
        String line;
        try {
            int i=1;
            while ((line = reader.readLine()) != null)
            {
                if(i!=1){
                    Map<String,String> map = readTxt(line);
                    if(map != null){
                        list.add(map);
                    }
                }else {
                    i=2;
                }
//                fileContent.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        read.close();
        return list;

    }

    public static Map<String,String> readTxt(String line){
        Map<String,String> map = new HashMap<String,String>();
        String[] parm = line.split("\\t");
        for (int i = 0; i <parm.length ; i++) {
            if (i == 0){
                map.put("Card Number",parm[i]);
            }else if (i==1){
                map.put("Password",parm[i]);

            }else if( i == 2){
                map.put("Card ParValue",parm[i]);

            }

        }
        for (String s : map.keySet()) {
            System.out.println("key:" + s);
            System.out.println("values:" + map.get(s));
        }
        System.out.println("======================");
        return map;

    }
}

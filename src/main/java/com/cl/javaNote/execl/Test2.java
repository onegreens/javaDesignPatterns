package com.cl.javaNote.execl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test2 {
    static PrintWriter writer;
    static Map mapping = new HashMap();

    public static void main(String[] args) throws IOException {
        String outFilePath = "D:\\project\\HB\\保定市各行业用电量3.txt";
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)));
        writer.println(StringUtils.join(Test.codes, "|"));

        initMaps();
        getFileContent("E:\\保定市全行业用电量统计");
        writer.close();

    }

    public static void initMaps() {
        for (int i = 0; i < Test.maps.length; i++) {
            String[] values =Test.maps[i];
            Map item = new HashMap();
            item.put("name", values[0].trim());
            item.put("category", values[1].trim());
            String type = values[2];
            item.put("type", "旧动能".equals(type) ? "old" : "new");
            mapping.put(values[0], item);
        }

    }


    public static void getFileContent(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                getFileContent(files[i]);
            }
        }

    }

    public static void getFileContent(File file) {
        ExcelReader_MapList util = new ExcelReader_MapList(file, 7);
        List<Map<String, Object>> mapList = null;
        try {
            mapList = util.init();
            String month = file.getName().split("_")[1];
            printList(month, util, mapList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printList(String month, ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            String name = String.valueOf(map.get(util.getKey() + 0));
            Map data = (Map) mapping.get(name.trim());
            if (data == null) continue;
            List list = new ArrayList();

            list.add(data.get("category"));
            list.add(data.get("type"));
//            list.add("total");
//            list.add("total");
            list.add("BD");
            list.add(month);
            String value1 = String.valueOf(map.get(util.getKey() + 1));
            if (StringUtils.isEmpty(value1)) {
                value1 = "0";
            }
            list.add(value1);
            String value = String.valueOf(map.get(util.getKey() + 5));
            if (StringUtils.isEmpty(value)) {
                value = "0";
            }
            list.add(value);

            list.add("month");
            writer.println(StringUtils.join(list, "|"));
        }
    }

}

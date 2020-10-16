package com.cl.javaNote.execl;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaoDingCounty {
    static List<Map> tradeList = new ArrayList<>();
    static List<Map> totalList = new ArrayList<>();
    static PrintWriter writer;
    static Map mapping = new HashMap();

    public static void main2(String[] args) throws IOException {
        String outFilePath = "D:\\project\\HB\\保定市各区县各行业用电量0928.txt";
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)));
        writer.println(StringUtils.join(Test.codes2, "\t"));

        initMaps();
        getFileContent("D:\\project\\HB\\各县公司2019年累计电量");
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        String outFilePath = "D:\\project\\HB\\保定市各区县各行业用电量0928.txt";
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)));
        writer.println(StringUtils.join(Test.codes2, "\t"));
        initMaps();
        getFileContent("D:\\project\\HB\\各县公司2019年累计电量");
        printList(filter(tradeList, "year", "type", "city_code", "category"));
//        printList(filter(tradeList, "section", "type", "city_code", "category"));
//        printList(filter(tradeList, "year", "type", "city_code", "category"));
        printList(addParam(filter(tradeList, "year", "type", "city_code"), "category"));
//        printList(addParam(filter(tradeList, "section", "type", "city_code"), "category"));
//        printList(addParam(filter(tradeList, "year", "city_code"), "category"));
        printList(addParam(filter(tradeList, "year", "city_code"), "type"));
//        printList(addParam(filter(tradeList, "section", "city_code"), "type"));
//        printList(addParam(filter(tradeList, "year", "city_code"), "type"));
        printList(filter(totalList, "year", "type", "city_code", "category"));
//        printList(filter(totalList, "section", "type", "city_code", "category"));
//        printList(filter(totalList, "year", "type", "city_code", "category"));
        writer.close();

    }


    public static void printList(List<Map> list) {
        for (int i = 0; i < list.size(); i++) {
            Map item = list.get(i);
            StringBuffer str = new StringBuffer();
            for (int j = 0; j < Test.codes2.length; j++) {
                str.append(item.get(Test.codes2[j])).append("\t");
            }
            writer.println(str.toString());
        }
    }

    public static List<Map> addParam(List<Map> list, String param) {
        for (int i = 0; i < list.size(); i++) {
            Map item = list.get(i);
            if ("category".equals(param)) {
                item.put("category", item.get("type"));
            } else if ("type".equals(param)) {
                item.put("category", "all");
                item.put("type", "all");
            }
        }
        return list;
    }

    public static List filter(List<Map> list, String type, String... strs) {
        Map<String, Map> storage = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> item = list.get(i);
            StringBuffer key = new StringBuffer();
            for (int j = 0; j < strs.length; j++) {
                key.append(item.get(strs[j])).append("_");
            }
            String times = item.get("times");
            if ("month".equals(type)) {
                key.append(times).append("_");
            } else if ("year".equals(type)) {
                key.append(times.substring(0, 4)).append("_");
            } else {
                Double s = Math.ceil(Integer.parseInt(times.substring(4, 6)) / 3);
                key.append(times.substring(0, 4)).append("Q").append(s.intValue()).append("_");
            }
            Map<String, Double> result = (Map) storage.get(key.toString());
            if (result == null) {
                result = new HashMap();
                result.put("num", 0D);
                result.put("power", 0D);
            }
            result.put("num", Double.valueOf(item.get("num")) + result.get("num"));
            result.put("power", Double.valueOf(item.get("power")) + result.get("power"));
            storage.put(key.toString(), result);
        }
        List relist = new ArrayList();
        for (String key : storage.keySet()) {
            Map item = storage.get(key);
            String[] keys = key.split("_");
            for (int j = 0; j < strs.length; j++) {
                item.put(strs[j], keys[j]);
            }
            item.put("times", keys[keys.length - 1]);
            item.put("total_type", type);

            relist.add(item);
        }
        return relist;
    }

    public static void initMaps() {
        for (int i = 0; i < Test.maps.length; i++) {
            String[] values = Test.maps[i];
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
            String countyName = (file.getName().split("_")[0]).replace("国网", "").replace("电力局", "").replace("供电公司", "");
//            printFirstList(month,countyName, util, mapList);
//            printList(month,countyName, util, mapList);
//
            printFirstList2(month, countyName, util, mapList);
            printList2(month, countyName, util, mapList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printList(String month, String countyName, ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            String name = String.valueOf(map.get(util.getKey() + 0));
            Map data = (Map) mapping.get(name.trim());
            if (data == null) continue;
            List list = new ArrayList();

            list.add(data.get("category"));
            list.add(data.get("type"));
            list.add(countyName);
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
            writer.println(StringUtils.join(list, "\t"));
        }
    }

    public static void printFirstList(String month, String countyName, ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            List list = new ArrayList();

            list.add("total");
            list.add("total");
            list.add(countyName);
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

            writer.println(StringUtils.join(list, "\t"));
            break;
        }
    }

    public static void printList2(String month, String countyName, ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            String name = String.valueOf(map.get(util.getKey() + 0));
            Map data = (Map) mapping.get(name.trim());
            if (data == null) continue;
            Map item = new HashMap();
            item.put("category", data.get("category"));
            item.put("type", data.get("type"));
            item.put("city_code", countyName);
            item.put("times", month);
            String value1 = String.valueOf(map.get(util.getKey() + 1));
            if (StringUtils.isEmpty(value1)) {
                value1 = "0";
            }
            item.put("num", value1);
            String value = String.valueOf(map.get(util.getKey() + 8));
            if (StringUtils.isEmpty(value)) {
                value = "0";
            }
            item.put("power", value);
            item.put("total_type", "month");
            tradeList.add(item);
        }
    }

    public static void printFirstList2(String month, String countyName, ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            Map item = new HashMap();
            item.put("category", "total");
            item.put("type", "total");
            item.put("city_code", countyName);
            item.put("times", month);
            String value1 = String.valueOf(map.get(util.getKey() + 1));
            if (StringUtils.isEmpty(value1)) {
                value1 = "0";
            }
            item.put("num", value1);
            String value = String.valueOf(map.get(util.getKey() + 8));
            if (StringUtils.isEmpty(value)) {
                value = "0";
            }
            item.put("power", value);
            item.put("total_type", "month");
            totalList.add(item);
            break;
        }
    }

}

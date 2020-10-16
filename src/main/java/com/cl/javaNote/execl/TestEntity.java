package com.cl.javaNote.execl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestEntity {


    static String[] keys = {"��ҵ����", "����", "����ͬ��", "����", "����ͬ��", "����", "����ͬ��", "��������������", "�����ۼ�", "�����ۼ�", "�ۼ�����������", "���ºϼ�", "����������������", "����ͬ�ºϼ�", "����ͬ��������������", "�ۼƺϼ�", "�ۼ�������������", "�����ۼƺϼ�", "�����ۼ�������������", "����", "����ͬ�ȣ�����", "�ۼ�", "�ۼ�ͬ�ȣ�����", "����ĩ��תǷ��", "�ۼ�Ƿ��", "���У�����", "���У���Ƿ", "���У�����"};
    static String[] codes = {"category", "type", "city_code", "month", "trade_name", "num_cur_month", "num_last_year_cur_month", "storage_cur_month", "storage_last_year_cur_month", "power_cur_month", "power_last_year_month", "power_cur_month_add", "power_cur_year_total", "power_last_year_total", "power_total_add", "fee_cur_month", "fee_sale_cur_month", "fee_last_year_month", "fee_sale_ast_year_month", "fee_cur_year_total", "fee_sale_cur_year_total", "fee_last_year_total", "fee_sale_last_year_total", "d1", "d2", "d3d", "d4", "d5", "d6", "dq", "dw", "dc"};
    static List<Record> list = new ArrayList<>();
    static Map mapping = new HashMap();

    public static void main(String[] args) throws IOException {
        initMaps();
        getFileContent("E:\\������ȫ��ҵ�õ���ͳ��");
        Record[] month = (Record[]) list.toArray();

    }


    static String split = "_";


    public static List<Record> sumSection() {
        for (int i = 0; i < list.size(); i++) {
            Record record = list.get(i);
        }
        return null;
    }

    static String getKey(Record record) {
        return new StringBuffer(record.getCategory()).append(split).append(record.getCode_type()).append(split).append(record.getCity_code()).append(split).toString();

    }

    public static void initMaps() {
        for (int i = 0; i < Test.maps.length; i++) {
            String[] values = Test.maps[i];
            Map item = new HashMap();
            item.put("name", values[0].trim());
            item.put("category", values[1].trim());
            String type = values[2];
            item.put("type", "�ɶ���".equals(type) ? "old" : "new");
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
            Record record = new Record();

            record.setCategory((String) data.get("category"));
            record.setCode_type((String) data.get("type"));
            record.setCity_code("BD");
            record.setTimes(month);
            record.setTotal_type("month");

            String value = String.valueOf(map.get(util.getKey() + 5));
            if (StringUtils.isEmpty(value)) {
                value = "0";
            }
            record.setPower(Double.valueOf(value));
            String value1 = String.valueOf(map.get(util.getKey() + 1));
            if (StringUtils.isEmpty(value1)) {
                value1 = "0";
            }
            record.setNum(Double.valueOf(value1));
            list.add(record);
        }
    }


}

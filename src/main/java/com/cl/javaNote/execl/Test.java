package com.cl.javaNote.execl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;


public class Test {


    static String[] keys = {"��ҵ����", "����", "����ͬ��", "����", "����ͬ��", "����", "����ͬ��", "��������������", "�����ۼ�", "�����ۼ�", "�ۼ�����������", "���ºϼ�", "����������������", "����ͬ�ºϼ�", "����ͬ��������������", "�ۼƺϼ�", "�ۼ�������������", "�����ۼƺϼ�", "�����ۼ�������������", "����", "����ͬ�ȣ�����", "�ۼ�", "�ۼ�ͬ�ȣ�����", "����ĩ��תǷ��", "�ۼ�Ƿ��", "���У�����", "���У���Ƿ", "���У�����"};
    static String[] codes = {"category", "type", "city_code", "month", "trade_name", "num_cur_month", "num_last_year_cur_month", "storage_cur_month", "storage_last_year_cur_month", "power_cur_month", "power_last_year_month", "power_cur_month_add", "power_cur_year_total", "power_last_year_total", "power_total_add", "fee_cur_month", "fee_sale_cur_month", "fee_last_year_month", "fee_sale_ast_year_month", "fee_cur_year_total", "fee_sale_cur_year_total", "fee_last_year_total", "fee_sale_last_year_total", "d1", "d2", "d3d", "d4", "d5", "d6", "dq", "dw", "dc"};
    static String[] codes2 = {"category", "type", "city_code", "times", "num", "power", "total_type"};
    static PrintWriter writer;
    static Map mapping = new HashMap();
    static String[][] maps = new String[][]{{"�ˡ�����ҵ", "34 ", "�¶���"},
            {"27.�������ͨ�ź����������豸����ҵ", "31 ", "�ɶ���"},
            {"1����ѧ�о��ͼ�������ҵ", "33 ", "�¶���"},
            {"3.�������Ϣ��������ҵ", "35 ", "�¶���"},
            {"2.����������ط���", "32 ", "�¶���"},
            {"1.���ź�������Ϣ�������ҵ", "36 ", "�¶���"},
            {"25.��·�����������պ�������������豸����ҵ", "37 ", "�¶���"},
            {"22.ͨ���豸����ҵ", "2502 ", "�ɶ���"},
            {"23.ר���豸����ҵ", "2502 ", "�ɶ���"},
            {"24.��������ҵ", "2502 ", "�ɶ���"},
            {"26.������е����������ҵ", "2502 ", "�ɶ���"},
            {"19.��ɫ����ұ����ѹ�Ӽӹ�ҵ", "24 ", "�ɶ���"},
            {"20.��ɫ����ұ����ѹ�Ӽӹ�ҵ", "24 ", "�ɶ���"},
            {"21.������Ʒҵ", "24 ", "�ɶ���"},
            {"17.�𽺺�������Ʒҵ", "21 ", "�ɶ���"},
            {"15.ҽҩ����ҵ", "33 ", "�¶���"},
            {"5. ��֯ҵ", "22 ", "�ɶ���"},
            {"6����֯��װ������ҵ", "22 ", "�ɶ���"},
            {"7��Ƥ�ëƤ����ë������Ʒ����Ьҵ", "22 ", "�ɶ���"},
            {"1.ũ��ʳƷ�ӹ�ҵ", "25 ", "�ɶ���"},
            {"2.ʳƷ����ҵ", "25 ", "�ɶ���"},
            {"3.�ơ����ϼ����Ʋ�����ҵ", "25 ", "�ɶ���"},
            {"14.��ѧԭ�Ϻͻ�ѧ��Ʒ����ҵ", "2506", "�ɶ���"},
            {"18.�ǽ���������Ʒҵ", "2504", "�ɶ���"},
    };

    public static void main(String[] args) throws IOException {
        String outFilePath = "D:\\project\\HB\\������ȫ��ҵ�õ���ͳ��.txt";
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)));
        writer.println(StringUtils.join(codes, "|"));
        initMaps();
        getFileContent("E:\\������ȫ��ҵ�õ���ͳ��");
        writer.close();

    }

    public static void initMaps() {
        for (int i = 0; i < maps.length; i++) {
            String[] values = maps[i];
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
            List list = new ArrayList();

            list.add(data.get("category"));
            list.add(data.get("type"));
            list.add("BD");
            list.add(month);
//            for (int i = 0; i < keys.length; i++) {
//                String value = String.valueOf(map.get(util.getKey() + i));
//                if (StringUtils.isEmpty(value)) {
//                    value = "0";
//                }
//                list.add(value);
//            }

            String value = String.valueOf(map.get(util.getKey() + 5));
            if (StringUtils.isEmpty(value)) {
                value = "0";
            }
            list.add(value);
            String value1 = String.valueOf(map.get(util.getKey() + 1));
            if (StringUtils.isEmpty(value1)) {
                value1 = "0";
            }
            list.add(value1);
            writer.println(StringUtils.join(list, "|"));
        }
    }

    public void printMap(ExcelReader_MapList util, List<Map<String, Object>> mapList) {
        List<Map> data = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            Map m2 = new HashMap();

            m2.put("classify_name", map.get(util.getKey() + "0"));
            for (int i = 4; i < util.getMaxCloumn(); i++) {
                if (keys.length > i - 1) {
                    m2.put(keys[i - 3], map.get(util.getKey() + i));
                }

            }
            data.add(m2);
        }
        System.out.println(JSON.toJSONString(data));
    }
}

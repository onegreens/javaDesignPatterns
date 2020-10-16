package com.cl.javaNote.execl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;


public class Test {


    static String[] keys = {"行业名称", "本月", "上年同月", "本月", "上年同月", "本月", "上年同月", "本月增长（％）", "本年累计", "上年累计", "累计增长（％）", "本月合计", "本月其中销售收入", "上年同月合计", "上年同月其中销售收入", "累计合计", "累计其中销售收入", "上年累计合计", "上年累计其中销售收入", "本月", "本月同比（±）", "累计", "累计同比（±）", "上年末结转欠费", "累计欠费", "其中：当年", "其中：陈欠", "其中：上年"};
    static String[] codes = {"category", "type", "city_code", "month", "trade_name", "num_cur_month", "num_last_year_cur_month", "storage_cur_month", "storage_last_year_cur_month", "power_cur_month", "power_last_year_month", "power_cur_month_add", "power_cur_year_total", "power_last_year_total", "power_total_add", "fee_cur_month", "fee_sale_cur_month", "fee_last_year_month", "fee_sale_ast_year_month", "fee_cur_year_total", "fee_sale_cur_year_total", "fee_last_year_total", "fee_sale_last_year_total", "d1", "d2", "d3d", "d4", "d5", "d6", "dq", "dw", "dc"};
    static String[] codes2 = {"category", "type", "city_code", "times", "num", "power", "total_type"};
    static PrintWriter writer;
    static Map mapping = new HashMap();
    static String[][] maps = new String[][]{{"八、金融业", "34 ", "新动能"},
            {"27.计算机、通信和其他电子设备制造业", "31 ", "旧动能"},
            {"1、科学研究和技术服务业", "33 ", "新动能"},
            {"3.软件和信息技术服务业", "35 ", "新动能"},
            {"2.互联网和相关服务", "32 ", "新动能"},
            {"1.电信和其他信息传输服务业", "36 ", "新动能"},
            {"25.铁路、船舶、航空航天和其他运输设备制造业", "37 ", "新动能"},
            {"22.通用设备制造业", "2502 ", "旧动能"},
            {"23.专用设备制造业", "2502 ", "旧动能"},
            {"24.汽车制造业", "2502 ", "旧动能"},
            {"26.电气机械和器材制造业", "2502 ", "旧动能"},
            {"19.黑色金属冶炼及压延加工业", "24 ", "旧动能"},
            {"20.有色金属冶炼及压延加工业", "24 ", "旧动能"},
            {"21.金属制品业", "24 ", "旧动能"},
            {"17.橡胶和塑料制品业", "21 ", "旧动能"},
            {"15.医药制造业", "33 ", "新动能"},
            {"5. 纺织业", "22 ", "旧动能"},
            {"6、纺织服装、服饰业", "22 ", "旧动能"},
            {"7、皮革、毛皮、羽毛及其制品和制鞋业", "22 ", "旧动能"},
            {"1.农副食品加工业", "25 ", "旧动能"},
            {"2.食品制造业", "25 ", "旧动能"},
            {"3.酒、饮料及精制茶制造业", "25 ", "旧动能"},
            {"14.化学原料和化学制品制造业", "2506", "旧动能"},
            {"18.非金属矿物制品业", "2504", "旧动能"},
    };

    public static void main(String[] args) throws IOException {
        String outFilePath = "D:\\project\\HB\\保定市全行业用电量统计.txt";
        writer = new PrintWriter(new BufferedWriter(new FileWriter(outFilePath)));
        writer.println(StringUtils.join(codes, "|"));
        initMaps();
        getFileContent("E:\\保定市全行业用电量统计");
        writer.close();

    }

    public static void initMaps() {
        for (int i = 0; i < maps.length; i++) {
            String[] values = maps[i];
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

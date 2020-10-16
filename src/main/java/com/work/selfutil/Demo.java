package com.work.selfutil;

import com.mysql.jdbc.PreparedStatement;
import com.work.jdbc.DBHelper;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cl on 2017/9/23.
 */
public class Demo {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;
    static String[] strs = new String[]{"org_no", "org_name", "p_org_no", "org_type", "sort_no", "org_shorthand", "hw_source", "hw_op_type", "hw_op_ts", "hw_current_ts", "hw_op_position", "hw_pos"};
    static List<Map> list = new ArrayList<>();
    static List<Map<String, String>> codes = new ArrayList<>();
    static List<String> keys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initData();
//        List<String> strs = doString("0");
        List<Map> strs = doStringEnd("0");
        System.out.println(codes.size());
//        insertData();

        PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(new File("code2.txt"))));

        writer.write("p_code|code|name|p_name|p_org_type|org_type\n");

        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i).get("p_code").equals(codes.get(i).get("code"))) {
                continue;
            }
            writer.write(codes.get(i).get("p_code") + "|" + codes.get(i).get("code") + "|" + codes.get(i).get("name") + "|" + codes.get(i).get("p_name")+ "|" + codes.get(i).get("p_org_type")+ "|" + codes.get(i).get("org_type"));
            writer.write("\n");
        }
        //如果不为writer调用close()，则缓冲区内容不会被刷新清空
        writer.close();
        if (db1 != null)
            db1.close();//关闭连接
    }


    public static void insertData() {

        PreparedStatement cmd = null;
        try {
            cmd = (PreparedStatement) db1.conn.prepareStatement("INSERT INTO o_org_all VALUES(?,?,?,?)");
            for (int i = 0; i < codes.size(); i++) {
                cmd.setString(1, (String) codes.get(i).get("p_code"));
                cmd.setString(2, (String) codes.get(i).get("code"));
                cmd.setString(3, (String) codes.get(i).get("name"));
                cmd.setString(4, (String) codes.get(i).get("p_name"));
                cmd.addBatch();
            }
            cmd.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static List<Map> doStringEnd(String pcode) {
        List<Map> result = new ArrayList<>();
        List nodes = getByProperties(pcode, "p_org_no");
        for (int i = 0; i < nodes.size(); i++) {
            Map node = (Map) nodes.get(i);
            List<Map> strings = doStringEnd((String) node.get("org_no"));
            if (strings.size() == 0) {
                result.add(node);
            } else {
                result.addAll(strings);
            }
            for (int j = 0; j < result.size(); j++) {
                Map map = new HashMap();
                if (keys.contains((String) node.get("org_no") + result.get(j).get("org_no"))) {
                    continue;
                } else {
                    keys.add((String) node.get("org_no") + result.get(j).get("org_no"));
                }
                map.put("p_code", ((String) node.get("org_no")).trim());
                map.put("p_org_type", ((String) node.get("org_type")).trim());
                map.put("p_name", ((String) node.get("org_name")).trim());
                map.put("org_type", ((String) result.get(j).get("org_type")).trim());
                map.put("code", ((String) result.get(j).get("org_no")).trim());
                map.put("name", ((String) result.get(j).get("org_name")).trim());
                codes.add(map);
            }
        }
        return result;
    }

    public static void initData() {
        sql = "select * from o_org";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                Map map = new HashMap();
                for (int i = 1; i <= strs.length; i++) {
                    map.put(strs[i - 1], ret.getString(i));
                }
                list.add(map);
            }//显示数据
            if (ret != null)
                ret.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List getByProperties(String value, String key) {
        List result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map map = list.get(i);
            if (value.equals(map.get(key))) {
                result.add(map);
            }
        }
        return result;
    }

    public static List<String> doString(String pcode) {
        List<String> result = new ArrayList<>();

        List nodes = getByProperties(pcode, "p_org_no");
        for (int i = 0; i < nodes.size(); i++) {
            Map node = (Map) nodes.get(i);
            List<String> strings = doString((String) node.get("org_no"));
            if (strings.size() > 0) {
                for (int j = 0; j < strings.size(); j++) {
                    result.add(strings.get(j));
                }
            } else {
                result.add((String) node.get("org_no"));
            }

        }
        return result;
    }
}

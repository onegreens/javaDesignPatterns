package com.work.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cl on 2017/9/23.
 */
public class Demo {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select * from vv_video_apply where va_content = '"+"as"+"'";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String uid = ret.getString(1);
                String content = ret.getString(2);
                System.out.println(uid + "\t" + content );
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.work.util.JedisUtils;

/**
 * Created by xin on 2017/7/19.
 */
public class JedisHelper {
    public final static int limit = 2;//接口访问受限记录存放的数据库号
    public final static String redisState = "1";//redis运行状态，1:开启，0:维护
    public final static String limitTableName = "go_interface_access_limit";//接口访问限制表表名
    public final static String limitKeyPrefix = "ifLimit:";//访问接口缓存表中key的前缀
}

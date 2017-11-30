package com.cl.javaNote.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by cl on 2017/9/26.
 */
public class StringSample {
    public static void main(String[] args) {
        //可以和命令行设置的值互通

        Jedis jedis = Connect.getJedis();
        jedis.set("name","zhangsan");
        System.out.println(jedis.get("name"));
    }
}

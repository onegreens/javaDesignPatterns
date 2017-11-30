package com.cl.javaNote.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by cl on 2017/9/26.
 */
public class Connect {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("ll12345678");

        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
    }

    public static Jedis theJedis;

    static Jedis getJedis() {
        if (theJedis == null) {
            theJedis = new Jedis("127.0.0.1", 6379);
            theJedis.auth("ll12345678");
        }
        return theJedis;
    }
}

package com.cl.javaNote.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by cl on 2017/9/26.
 */
public class RedisKeyJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = Connect.getJedis();
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}

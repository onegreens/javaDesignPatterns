package com.work.util.JedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * Created by xin on 2017/6/22.
 * 要存储对象的话 需要先将对象序列化
 * 使用SerializeUtil的方法 参考TestPo
 */
public class JedisUtils {
    public static JedisPool jedisPool;

    //private  Jedis jedis;
    static {
        if (jedisPool == null) {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            Map<String, String> map = null;
            try {
                map = PropertyUtils.property_to_map_fromSrc("/redis.properties");
            } catch (Exception e) {
                e.printStackTrace();
            }

            //最大连接数
            poolConfig.setMaxTotal(Integer.parseInt(map.get("redis.pool.maxActive")));
            //最大空闲连接数
            poolConfig.setMaxIdle(Integer.parseInt(map.get("redis.pool.maxIdle")));
            //在获取链接的时候设置的超时时间
            poolConfig.setMaxWaitMillis((Long.parseLong(map.get("redis.pool.maxWait"))));

            //校验连接可用性
            poolConfig.setTestOnBorrow(Boolean.valueOf(map.get("redis.pool.testOnBorrow")));
            poolConfig.setTestOnReturn(Boolean.valueOf(map.get("redis.pool.testOnReturn")));

            jedisPool = new JedisPool(poolConfig, map.get("redis.ip"),
                    Integer.parseInt(map.get("redis.port")), Integer.parseInt(map.get("redis.pool.timeout")), map.get("redis.auth"));

        }
    }

    //获取一个jedis实例
    public static Jedis getJedis() {

        Jedis jedis = jedisPool.getResource();
        return jedis;

    }

    //返回jedis实例到资源池
    public static void returnRes(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
  /*  public static void test(){
        if(null == jedis){
            System.out.println("error");
        }
        Map map = new HashMap();
        map.put("String","asdqwe12322");
        map.put("int","1");
        map.put("Chinese","测试");
        jedis.hmset("mapTest",map);*/


    public static void main(String args[]) throws Exception {

        Jedis jedis = getJedis();
        jedis.select(1);
        jedis.set("user", "namess");
        jedis.select(2);
        System.out.println(jedis.get("user"));
        jedis.select(1);
        System.out.println(jedis.get("user"));

        //test();
    }
}

package com.work.entity;

import com.work.util.JedisUtils.JedisUtils;
import com.work.util.JedisUtils.SerializeUtil;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cl on 2017/11/21.
 */
public class TestPo implements Serializable {
    private Integer id;
    private String name;
    private List list;
    private Map map;

    public TestPo() {
    }

    public TestPo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "TestPo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getJedis();
        jedis.select(1);
        TestPo testPo = new TestPo(1, "name");
        Map map = new HashMap();
        map.put("1","test");
        List list = new ArrayList();
        list.add("testKist");
        testPo.setMap(map);
        testPo.setList(list);
        jedis.set("person:100".getBytes(), SerializeUtil.serialize(testPo));
        byte[] person = jedis.get(("person:100").getBytes());
        TestPo testPo1 = (TestPo) SerializeUtil.unserialize(person);
        System.out.println(testPo1);
    }
}

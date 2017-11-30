package com.work.shorturl;

import com.work.util.HttpclientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cl on 2017/9/23.
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        String long_url = "http://www.ishuhui.com/cartoon/num/2-0-n-652";
        Map<String, String> params = new HashMap<String, String>();
        params.put("url",long_url);
        String path = "http://vurl.cn/create.php";
        Map<String, Object> map = HttpclientUtils.post(path,params);
        System.out.println(map);
    }
}

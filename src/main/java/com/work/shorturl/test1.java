package com.work.shorturl;


import com.work.util.HttpclientUtils;

import java.net.URLEncoder;

import static com.work.secret.MD5Utils.*;

import java.util.*;

/**
 * Created by cl on 2017/9/23.
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        String long_url = "http://www.ishuhui.com/cartoon/num/2-0-n-652";
        long_url = URLEncoder.encode(long_url, "utf-8");

        String appkey = "19484d79a1fa94ecfc2003000debea77";
        String sign = md5(appkey + md5(long_url).toLowerCase()).toLowerCase();
        System.out.println(sign);
        System.out.println(sign.length());
        String url = "http://www.mynb8.com/api/sina?appkey=" + appkey + "&sign=" + sign + "&long_url="+long_url;
        Map<String, Object> map = HttpclientUtils.get(url);
        System.out.println(map);
    }

}

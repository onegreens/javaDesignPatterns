package com.work.secret;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Ienovo
 *         最后更新日期：2015-10-24
 */


public class MD5Utils {
    public static void main(String[] args) throws Exception {
        System.out.println(md5(md5("HUANGzeng")));
    }

    /**
     * 利用MD5进行加密
     * 　　* @param str  待加密的字符串
     * 　　* @return  加密后的字符串
     * 　　* @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * 　　 * @throws UnsupportedEncodingException
     *
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
//加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    /**
     * md5加密
     */
    public static String md5(String s) throws Exception {

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw e;
        }

    }

    public static String superMd5(String s) throws Exception {
        return md5(md5(md5(s))) + md5(s);
    }

}

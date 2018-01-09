/**
 * Created by cl on 2017/12/1.
 * 在example1基础上添加ssl证书
 *
 * 1. 生成证书，通过使用keytool
 *  直接在控制台的Terminal中输入：
 *  keytool -genkey -v -alias bluedash-ssl-demo-client -keyalg RSA -keystore ./client_ks -dname "CN=localhost,OU=cn,O=cn,L=cn,ST=cn,C=cn" -storepass client -keypass 456456
 *  会生成一个文件client_ks
 */
package com.cl.javaNote.ssl.example2;
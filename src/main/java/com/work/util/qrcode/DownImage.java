package com.work.util.qrcode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by cl on 2017/12/12.
 */
public class DownImage {


    public void saveToFile(String destUrl, String savePath) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            File file = new File(savePath);
            File f = new File(savePath);
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            fos = new FileOutputStream(file);
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassCastException e) {
            e.printStackTrace();

        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DownImage dw = new DownImage();
        dw.saveToFile("https://mmbiz.qpic.cn/mmbiz_png/jSotYorAhwOh5rC2treQiatnIdoVgc0phL5UM03ibTepLwWdslIUYumnKVjW8OmpekzSxsKibBPC6QQWcaTq5csmw/0?wx_fmt=png", "img\\test1.png");
    }
}

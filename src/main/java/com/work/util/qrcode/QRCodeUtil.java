package com.work.util.qrcode;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * Created by cl on 2017/12/12.
 */
public class QRCodeUtil {
    public static void main(String[] args) {
        System.out.println("文本信息"+getMessageByHref("https://mmbiz.qpic.cn/mmbiz_png/jSotYorAhwOh5rC2treQiatnIdoVgc0phL5UM03ibTepLwWdslIUYumnKVjW8OmpekzSxsKibBPC6QQWcaTq5csmw/0?wx_fmt=png"));
    }
    public static  String getMessageByHref(String href) {
        HttpURLConnection httpUrl = null;
        URL url = null;
        InputStream inputStream = null;
        try {
            url = new URL(href);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            inputStream =httpUrl.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        } finally {
            try {
                httpUrl.disconnect();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
            /* 解二维码 */
        if (image!=null){
            QRCodeDecoder decoder = new QRCodeDecoder();
            String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
            return decodedData;
        }
        return null;
    }

    /**
     * decode qrcode image.
     *
     * @param qrcodePicfilePath
     * @return decoding value.
     */
    public static String decode(String qrcodePicfilePath) {
        /* 读取二维码图像数据 */
        File imageFile = new File(qrcodePicfilePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Decoding failed, read QRCode image error: " + e.getMessage());
            return null;
        }
        /* 解二维码 */
        QRCodeDecoder decoder = new QRCodeDecoder();
        String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
        return decodedData;
    }

    public static void main1(String[] args) {
        QRCodeDecoder decoder = new QRCodeDecoder();
        File imageFile = new File("img\\test1.png");
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("识别二维码");

        String decodedData = new String(decoder.decode(new J2SEImageGucas(image)));
        System.out.println(decodedData);

    }
}

class J2SEImageGucas implements QRCodeImage {
    BufferedImage image;

    public J2SEImageGucas(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }
}
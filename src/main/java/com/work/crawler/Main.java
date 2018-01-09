package com.work.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by cl on 2017/12/23.
 */
public class Main {
    /**
     * 获取document
     */
    public static Document getDocument(String url) {
        Document document = null;
        try {

            document = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) {
        String url = "https://www.qidian.com/all";
        Document document = getDocument(url);
        Elements elements = document.select("a[data-eid=\"qd_B58\"]");
        if (elements == null || elements.size()<1)
            System.out.println("错了");
        for(Element element : elements)
            System.out.println(element.text());

    }
}

package com.work.search;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cl on 2017/6/24.
 * 中文分词
 */
public class ChineseSplit {

//    public static void main(String[] args) throws IOException {
//        String str = "苹果香蕉你是否是啊死后啊按平均法是积分趴实际奥氮平佛杀发泡剂按商品房就是怕警匪片";
//        StringReader reader = new StringReader(str);
//        //对于不同的jar，这个IKSegmenter可能会有区别
//        IKSegmenter ik = new IKSegmenter(reader, true);//当为true时，分词器进行最大词长切分
//        Lexeme lexeme = null;
//        while ((lexeme = ik.next()) != null)
//            System.out.println(lexeme.getLexemeText());
//    }

    public static void main(String[] args) throws IOException {
        String str = "sss 苹果";
        Map<String,String> strs = mapArray(str);
        for (String s : strs.values()) {
            System.out.println("values:" + s);
        }
    }

    public static Map<String,String> mapArray(String str) throws IOException {
        Map<String,String> strings = new HashMap<String, String>();
        StringReader reader = new StringReader(str);
        IKSegmenter ik = new IKSegmenter(reader,true);
        Lexeme lexeme = null;
        Integer i = 0;
        while((lexeme = ik.next())!=null){
            i++;
            strings.put(i.toString(),lexeme.getLexemeText());
        }
        return strings;
    }

    public static List<String> springArray(String str) throws IOException {
        Map<String,String> map = mapArray(str);
        List<String> strs = (List<String>) map.values();
        return strs;
    }


}

搜索功能：

Lucene：一个开放源代码的全文检索引擎工具包（未了解）
关键词库：（暂未了解）



## 在原有基础上

### 思路一：拆分字段

1. 在输入字段seach没有获取到对应接口时，（字段格式：以空格分开两个字段），采用拆分字段
2. 拆分字段为字符串数组str[]
3. 首先通过 str[0] 搜索出所有的数据 list ，在通过循环匹配对应的数据
4. 判断 list[i] 数据中是否包含搜索字段 str[j]，不包含的数据就清除 list[i] ，若最后结果为空，则保留上次匹配前的数据 list，结果不为空，则将数据递送至下次匹配 newlist (遍历str[])
5. 将最后的结果 newlist 返回

测试代码（额外部分省略）：

```java
 /**
     * 方法说明：以下方法为测试方法
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String name = "apple 苹果";
        DBHelper dataUtils = getDataUtils();
        List<Map<String, Object>> list = GoodsServiceHelper.searchList(dataUtils, name, 0, 10);
        if (list.size() == 0 && name.contains(" ")) {//如果没有搜索结果，并且字符串中包含空格（可添加其他分割标识）
          //此时可以输出提示信息说最匹配的结果,
            String[] strs = name.split(" ");
            list = GoodsServiceHelper.searchList(dataUtils, strs[0], 0, 10);
            list = seachRule(strs, list);
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    public static List<Map<String, Object>> seachRule(String[] strs, List<Map<String, Object>> list) {
        for (int i = 1; i < strs.length; i++) {
            seachRule(strs[i], list);
        }
        return list;
    }

    public static List<Map<String, Object>> seachRule(String str, List<Map<String, Object>> list) {
        List<Map<String, Object>> listCopy = list;
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            String goods_name = (String) map.get("goods_name");
            String seachword = str;
            if (!(goods_name).contains(seachword)) {
                list.remove(map);
            }
        }
        if (list.size() == 0) {
            list = listCopy;
        }
        return list;
    }
```

效果：即使不能对用户搜索字段进行完全匹配，可以返回近似的信息

### 思路二：中文分词

中文分词IKAnalyzer

1. 下载
http://code.google.com/p/ik-analyzer/downloads/list
其他地址可再寻找

2. 目录结构
/ext_stopword.dic （停词列表）
/IKAnalyzer.cfg.xml （配置文件）
/IKAnalyzer3.2.8.jar
/doc3.2.8

3. /IKAnalyzer.cfg.xml （配置文件）
```xml
<properties>  
	<comment>IK Analyzer 扩展配置</comment>
	<!--用户可以在这里配置自己的扩展字典 -->
	<!-- 用于在现有的词库基础上进行扩展 -->
	<entry key="ext_dict">ext.dic;</entry>

	<!--用户可以在这里配置自己的扩展停止词字典-->
	<entry key="ext_stopwords">stopword.dic;</entry> 
</properties>
```

4. 实例
```java
public static void main( String[] args ) throws IOException {
        String str = "苹果香蕉你是否是啊死后啊按平均法是积分趴实际奥氮平佛杀发泡剂按商品房就是怕警匪片";
        StringReader reader = new StringReader(str);
        //对于不同的jar，这个IKSegmenter可能会有区别
        IKSegmenter ik = new IKSegmenter(reader,true);//当为true时，分词器进行最大词长切分
        Lexeme lexeme = null;
        while((lexeme = ik.next())!=null)
            System.out.println(lexeme.getLexemeText());
    }
```
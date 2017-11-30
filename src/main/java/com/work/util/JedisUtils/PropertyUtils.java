package com.work.util.JedisUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @author Ienovo
 * 类说明：
 * 该类主要用于配置文件的读取
 * 最后修改时间：2015-10-12 20:44
 * 最后修改：添加一个从源文件开始算目录的方法
 */

public class PropertyUtils {
	
/*	private File file = null; //文件
	private FileInputStream inputStream = null;//输入流
	private Properties properties = null;//配置信息
*/	
	
	
	/**
	 * 方法说明：从配置文件对象中获取所有键值对
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map<String, String> getMap_from_property(Properties properties) throws Exception {
		Enumeration<String> list = (Enumeration)properties.propertyNames();
		Map<String, String> map = new HashMap<String, String>();
		String key = null;
		String value = null;
		while (list.hasMoreElements()) {
			key = (String) list.nextElement();
			value = properties.getProperty(key);
				//Property 默认以 ISO-8859-1 对文件进行读取,这里加一个转换方法
			value = new String(value.getBytes("ISO-8859-1") , Charset.forName("UTF-8"));
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * 方法说明：读取配置文件并将配置导出到Map中
	 * 参数说明：
	 * path : 文件地址(栗子：F:/demo.xml);
	 * 备注：
	 * @throws Exception 
	 * 
	 */
	public static Map<String, String> property_to_map(String path) throws Exception {
		File file = new File(path);
		FileInputStream fin = new FileInputStream(file);
		Map<String, String> map = property_to_map(fin);
		fin.close();
		return map;
	}
	
	/**
	 * 方法说明：从源文件目录中读取配置文件并将配置导出到Map中
	 * 参数说明：
	 * path : 文件地址(栗子：F:/demo.xml);
	 * 备注：
	 * 文件路径从源文件目录开始算计(src文件夹下)
	 * 栗子：
	 * 比如配置文件位置：src/config/config.property
	 * 则 path 参数为：/config/config.property
	 * "/"不能少
	 * @throws Exception 
	 */
	public static Map<String, String> property_to_map_fromSrc(String path) throws Exception {
//		String path = "/com/imicke/config/database.property";//配置文件路径
//		InputStream in = Class.class.getResourceAsStream(path);
		InputStream in = PropertyUtils.class.getResourceAsStream(path);//Class类路径在网络环境下貌似不是从 classes 文件夹下算起的,还是用回 PropertyUtils类吧
		Map<String, String> map = property_to_map(in);
		in.close();
		return map;
	}
	
	/**
	 * 方法说明：读取配置文件并将配置导出到Map中
	 * 参数说明：
	 * fin : 文件流;
	 * 备注：
	 * Q:关于为毛要添加这样一个方法？
	 * A:因为,经常有其他方法,直接返回了FileInputStream,所以得有这样一个接口
	 * @throws Exception 
	 */
	public static Map<String, String> property_to_map(InputStream fin) throws Exception {
		Properties properties = new Properties();
		properties.load(fin);
		Map<String, String> map = getMap_from_property(properties);
		fin.close();
		return map;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "F:/database.property";
//		String path = "C:/Users/Ienovo/Desktop/goodsManager/1/iPhone6 Plus 5.5英寸 64G/info.property";
		Map<String, String> map = null;
		try {
			map = PropertyUtils.property_to_map(path);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		for(Map.Entry<String, String> key : map.entrySet()) {
			String value = new String(key.getValue().getBytes("ISO-8859-1") , Charset.forName("GBK"));
			value = new String(value.getBytes("GBK") , Charset.forName("UTF-8"));
			System.out.println(key.getKey() + "---" + value);
		}
	}
	
	
	
	
	
	
	
	/**
	 * 方法说明：释放资源
	 */
/*	public boolean close() {
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	/**
	 * 方法说明：读取配置文件中指定键值的数据
	 */
/*	public String getValue(String key) {
		String value = properties.getProperty(key);
		return value;
	}*/		
	
	
}

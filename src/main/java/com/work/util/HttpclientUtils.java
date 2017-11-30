package com.work.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;


public class HttpclientUtils {
	public static Map<String, Object> get(String url) throws Exception {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;

		try {
			httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String entitysString = EntityUtils.toString(entity, "UTF-8");
			if (entitysString.indexOf("callback(") != -1) {
				entitysString = entitysString.substring(entitysString.indexOf("{"), entitysString.indexOf("}") + 1);
			}
			returnMap = JsonUtils.json2map(entitysString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.close();
			httpClient.close();
		}

		return returnMap;
	}

	public static Map<String, Object> post(String url, Map<String, String> params) throws Exception {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;

		try {

			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
			httpPost.setEntity(uefEntity);

			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			String entitysString = EntityUtils.toString(entity, "UTF-8");
			if (entitysString.indexOf("callback(") != -1) {
				entitysString = entitysString.substring(entitysString.indexOf("{"), entitysString.indexOf("}") + 1);
			}
			returnMap = JsonUtils.json2map(entitysString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.close();
			httpClient.close();
		}

		return returnMap;
	}
}

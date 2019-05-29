/**
 * @File : HttpUtil.java
 * @Description :
 * 
 * 
 * @author : Changshuanhu
 * @Date : 2016年11月22日
 * @Version : V0.1
 * @Copyright : 幸福时代网络科技（北京）股份有限公司
 */
package com.furui.ydfr.common.util;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String httpGet(String url) {

		try {
			HttpEntity entity = Request.Get(url).execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String httpPost(String url, String data) {

		try {

			HttpEntity entity = Request.Post(url).useExpectContinue().version(HttpVersion.HTTP_1_1)
					.bodyString(data, ContentType.create("application/json", Consts.UTF_8)).execute().returnResponse()
					.getEntity();

			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static String formPost(String url, String data) {

		try {

			HttpEntity entity = Request.Post(url).useExpectContinue().version(HttpVersion.HTTP_1_1)
					.bodyString(data, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8)).execute()
					.returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String httpGetSingle(String url) {

		try {
			HttpEntity entity = Request.Get(url).execute().returnResponse().getEntity();
			return entity != null ? EntityUtils.toString(entity, Consts.UTF_8) : null;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}

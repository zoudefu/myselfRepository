package HttpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientPorxy {

	public static void main  (String[] args) 
		    throws ClientProtocolException, IOException
	      {
		    CloseableHttpClient httpClient = HttpClients.createDefault();
		    HttpGet httpGet = new HttpGet("http://www.tuicool.com/");
		    httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
		    HttpHost proxy=new HttpHost("175.55.213.235", 9999);//构建代理想
		    RequestConfig config=RequestConfig.custom()
		    		.setConnectTimeout(5000)//设置连接超时
		    		.setSocketTimeout(5000)//设置读取超时
		    		.setProxy(proxy).build();//将代理放在配置里
		    httpGet.setConfig(config);//将配置放在httpGet里
		    CloseableHttpResponse response = httpClient.execute(httpGet);
		    HttpEntity entity = response.getEntity();
		   EntityUtils.toString(entity, "utf-8");
		    response.close();
		    httpClient.close();
		  }
}

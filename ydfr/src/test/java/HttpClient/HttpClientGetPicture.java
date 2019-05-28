package HttpClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClientGetPicture  {
	public static void main  (String[] args) 
		    throws ClientProtocolException, IOException
	      {
		    CloseableHttpClient httpClient = HttpClients.createDefault();
		    HttpGet httpGet = new HttpGet("http://www.java1234.com/gg/dljd4.gif");
		    httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
		    CloseableHttpResponse response = httpClient.execute(httpGet);
		    HttpEntity entity = response.getEntity();
		    System.out.println(entity.getContentType().getValue());//获得返回资源类型
		    response.getStatusLine().getStatusCode();//返回请求的状态
		    System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8"));
		    if(entity!=null){
			   InputStream inputStream=entity.getContent();
			    FileUtils.copyInputStreamToFile(inputStream, new File("D://bb.gif"));
		    }
		    response.close();
		    httpClient.close();
		  }
}

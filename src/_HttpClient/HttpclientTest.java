package _HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class HttpclientTest {
	public static void main(String[] args) throws Exception {
		
		/*String doGet = doGet("http://www.ctrip.com/", new HashMap<>());
		System.out.println(doGet);*/
		 
		CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom().setProxy(new HttpHost("192.168.0.233", 8888)).build();
		try {
			
			HttpGet post = new HttpGet("http://www.bus365.com");
			BasicClientCookie cookie = new BasicClientCookie("name", "zhaoke");
			cookie.setVersion(0);
			cookie.setDomain("bus365.com"); // 设置范围
			cookie.setPath("/");
			cookieStore.addCookie(cookie);
			HttpClientContext context = new HttpClientContext();
			context.setCookieStore(cookieStore);
			CloseableHttpResponse execute = httpClient.execute(post,context);//
			
			InputStream content = execute.getEntity().getContent();
			HttpEntity entity = execute.getEntity();
			Header[] allHeaders = execute.getAllHeaders();
			for (Header header : allHeaders) {
				System.out.println(header.getName());
				System.out.println(header.getValue());
				
			}
			List<Cookie> cookies = cookieStore.getCookies();
			for (int i = 0; i < cookies.size(); i++) {
				System.out.println("Local cookie: " + cookies.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	

	public static String doGet(String url, Map<String, String> param) {
		String result = null;
		HttpGet httpGet = new HttpGet();
		CloseableHttpClient client = getClient();
		CloseableHttpResponse response = null;
		try {
			RequestConfig config = RequestConfig.copy(config()).setProxy(new HttpHost("192.168.0.233", 8888)) .build();
			httpGet.setConfig(config);
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (Entry<String, String> entry : param.entrySet()) {
					builder.addParameter(entry.getKey(), entry.getValue());
				}
			}
			URI build = builder.build();
			httpGet.setURI(build);
			response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity, "UTF-8");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			try {
				response.close();
				client.close();
			} catch (IOException e) {
			}
		}
		return result;
	}

	public static CloseableHttpClient getClient() {
		return HttpClients.custom().setDefaultRequestConfig(config()).setDefaultCookieStore(new BasicCookieStore())
				.build();
	}

	public static RequestConfig config() {
		RequestConfig config = RequestConfig.custom()
				// 连接池的超时时间
				.setConnectionRequestTimeout(5000)
				// 连接的超时时间
				.setConnectTimeout(5000)
				// 读取socket的超时时间
				.setSocketTimeout(10000).build();
		return config;
	}
}

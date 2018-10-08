package _HttpClient;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

public class NewTest {
	public static void main(String[] args) {
		
	    CookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setProxy(new HttpHost("192.168.0.233",8888))
	             .setDefaultCookieStore(cookieStore)
	             .build();
	     try {
	     	
	          HttpPost post = new HttpPost("http://www.baidu.com");
	          post.setHeader("Cookie","hahaha=12321321");
	          BasicClientCookie cookie = new BasicClientCookie("name", "zhaoke"); 
	          cookie.setVersion(0);  
	          cookie.setDomain(".baidu.com");   //设置范围
	          cookie.setPath("/"); 
	          cookieStore.addCookie(cookie);
	          httpClient.execute(post);//
	          List<Cookie> cookies = cookieStore.getCookies();
	          for (int i = 0; i < cookies.size(); i++) {
	              System.out.println("Local cookie: " + cookies.get(i));
	          }
	        } catch (Exception e) {
				e.printStackTrace();
			}finally{
				
			}
		}

}

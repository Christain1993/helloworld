package _HttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.HttpContext;

public class CookieTest {
	
	public static void main(String[] args) {

		CookieStore store = new BasicCookieStore();
		BasicClientCookie cookie = new BasicClientCookie("name", "zhaoke");
		cookie.setVersion(0);
		cookie.setDomain(".bus365.com"); // 设置范围 
		cookie.setPath("/"); 
		store.addCookie(cookie);

//		store.addCookie(new BasicClientCookie("posit", "北京市"));
//		store.addCookie(new BasicClientCookie("bus365_SESSION",
//				"8d2fcc51ef8b2912dc19ddce1e36c7a097913b81-%00___ID%3A8fb19b36-d7ce-41bc-9c50-e38a4c18f8c6%00%00___AT%3A6a1d7b5449f37ddfa39ed887c7b3deac59b81d7a%00; loginName=13223376437"));
//		store.addCookie(new BasicClientCookie("loginName", "13223376437"));
//		store.addCookie(new BasicClientCookie("5fe845d7c136951446ff6a80b8144467",
//				"{\"token1\":\"8fb19b36-d7ce-41bc-9c50-e38a4c18f8c6%2313223376437%23%25E8%25B5%25B5%25E5%25AE%2587%2390161060001840647\",\"token2\":\"ADED36CA97F6C3E353E90575020547C87F3BB585C6CE788BA51FF344CE1EFC92FDF4DA530DB4799E9B7CB918D71564A441C5E476D29FE475AF59378FB9195F50BA88A12192988AC43310B16D7AC7838D\"}"));
//		store.addCookie(new BasicClientCookie("his_login_url", "http://www.bus365.com/login0|http://www.bus365.com/"));
		HttpClientContext context = new HttpClientContext();
		context.setCookieStore(store);
		Map<String, String> map = new HashMap<>();
		map.put("Cookie", "posit=北京市; bus365_SESSION=8d2fcc51ef8b2912dc19ddce1e36c7a097913b81-%00___ID%3A8fb19b36-d7ce-41bc-9c50-e38a4c18f8c6%00%00___AT%3A6a1d7b5449f37ddfa39ed887c7b3deac59b81d7a%00; loginName=13223376437; TINGYUN_DATA=%7B%22id%22%3A%22XYbpWiu5pvw%23BvH5hbT_p28%22%2C%22n%22%3A%22WebAction%2FPlayController%2FImagevalidateAction.createValidateImage%22%2C%22a%22%3A13%2C%22q%22%3A0%2C%22tid%22%3A%22%22%7D; 5fe845d7c136951446ff6a80b8144467=\"{\\\"token1\\\":\\\"8fb19b36-d7ce-41bc-9c50-e38a4c18f8c6%2313223376437%23%25E8%25B5%25B5%25E5%25AE%2587%2390161060001840647\\\",\\\"token2\\\":\\\"ADED36CA97F6C3E353E90575020547C87F3BB585C6CE788BA51FF344CE1EFC92FDF4DA530DB4799E9B7CB918D71564A441C5E476D29FE475AF59378FB9195F50BA88A12192988AC43310B16D7AC7838D\\\"}\"; his_login_url=http://www.bus365.com/login0|http://www.bus365.com/");
		String doGet = HttpClientUtils.doGet("http://www.bus365.com/", null, null, map, store);

		System.out.println(doGet);
	}

	
	

}	

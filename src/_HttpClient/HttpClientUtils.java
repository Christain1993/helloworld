package _HttpClient;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

	public static String doGet(String url, Map<String, String> param,HttpContext context) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.custom().setProxy(new HttpHost("192.168.0.233", 8888)).build();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (Entry<String, String> entry : param.entrySet()) {
					builder.addParameter(entry.getKey(), entry.getValue());
				}
			}
			URI uri = builder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet,context);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
				EntityUtils.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	public static String doGet(String url, Map<String, String> param,HttpContext context,Map<String,String> header) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (Entry<String, String> entry : param.entrySet()) {
					builder.addParameter(entry.getKey(), entry.getValue());
				}
			}
			URI uri = builder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			
			if(header!=null) {
				Set<Entry<String, String>> entrySet = header.entrySet();
				for (Entry<String, String> entry : entrySet) {
					httpGet.setHeader(entry.getKey(),entry.getValue());
				}
			}
			
			// 执行请求
			response = httpclient.execute(httpGet,context);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
				EntityUtils.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	public static String doGet(String url, Map<String, String> param,HttpContext context,Map<String,String> header,CookieStore store) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.custom().setProxy(new HttpHost("192.168.0.233", 8888))
				.setDefaultCookieStore(store).build();
		String resultString = "";
		CloseableHttpResponse response = null;
		
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (Entry<String, String> entry : param.entrySet()) {
					builder.addParameter(entry.getKey(), entry.getValue());
				}
			}
			URI uri = builder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			
			if(header!=null) {
				Set<Entry<String, String>> entrySet = header.entrySet();
				for (Entry<String, String> entry : entrySet) {
					httpGet.setHeader(entry.getKey(),entry.getValue());
				}
			}
			
			// 执行请求
			response = httpclient.execute(httpGet,context);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
				EntityUtils.consume(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}


	public static String doGet(String url) {
		return doGet(url, null,null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}

	/**
	 * 请求的参数类型为json
	 * 
	 * @param url
	 * @param json
	 * @return {username:"",pass:""}
	 */
	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet2(String url, Map<String, String> param) {
		List<NameValuePair> params = new ArrayList<>();
		for (Entry<String, String> entry : param.entrySet()) {
			NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
			params.add(pair);
		}
		RequestBuilder.post(url).addParameters(params.toArray(new NameValuePair[params.size()]))
				.setHeader("Content-Type", "text/html; charset=UTF-8");

		return url;

	}

	public RequestConfig requestConfig() throws ClientProtocolException, IOException {
		// 新建一个RequestConfig：
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				// 一、连接目标服务器超时时间：ConnectionTimeout-->指的是连接一个url的连接等待时间
				.setConnectTimeout(5000)
				// 二、读取目标服务器数据超时时间：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间
				.setSocketTimeout(5000)
				// 三、从连接池获取连接的超时时间:ConnectionRequestTimeout
				.setConnectionRequestTimeout(5000).build();

		// 这个超时可以设置为客户端级别,作为所有请求的默认值：
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
		// httpclient.execute(httppost);的时候可以让httppost直接享受到httpclient中的默认配置.

		// Request不会继承客户端级别的请求配置，所以在自定义Request的时候，需要将客户端的默认配置拷贝过去：
		HttpGet httpget = new HttpGet("http://www.apache.org/");
		URIBuilder builder = new URIBuilder();
		RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig)
				.setProxy(new HttpHost("myotherproxy", 8080)).build();
		httpget.setConfig(requestConfig);
		// httpget可以单独地使用新copy的requestConfig请求配置,不会对别的request请求产生影响
		return requestConfig;
	}
}
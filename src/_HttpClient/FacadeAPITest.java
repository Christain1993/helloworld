package _HttpClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class FacadeAPITest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String asString = Request.Get("http://www.baidu.com")
        .connectTimeout(1000)
        .socketTimeout(1000)
        .execute().returnContent().asString();
		System.out.println(asString);
	}
}

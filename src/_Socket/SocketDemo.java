package _Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress byName = InetAddress.getByName("www.bus365.com");
		System.out.println(byName);
		String hostAddress = byName.getHostAddress();
		System.out.println(hostAddress);
	}
}

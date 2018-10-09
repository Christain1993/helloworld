package _IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInOutStreamTest {
	public static void main(String[] args) throws Exception {
		output();
	}
	public static void input() throws Exception {
		File f = new File(".//test");
		InputStream is = new FileInputStream(f);
//		int available = is.available();
//		System.out.println(available +"==========");
//		byte[] buf = new byte[available];
//		is.read(buf);
//		for (byte b : buf) {
//			System.out.println(b);
//		}
		int temp = 0;
		OutputStream os = new FileOutputStream(".//test2");
		while((temp = is.read())!=-1) {
			System.out.println(temp);
			os.write(temp);
		}
		is.close();
		os.close();
//		System.out.println(new String(buf,"ISO-8859-1"));
	}
	public static void output() throws Exception {
		File f = new File(".//test");
//		if(!f.exists()) {
//			f.createNewFile();
//		}
		OutputStream os = new FileOutputStream(f);
		for (int i = 0; i < 100 ; i++) {
			String str = "参数"+i+"\r\n";
			os.write(str.getBytes());
			os.flush();
		}
		os.close();
	}
}

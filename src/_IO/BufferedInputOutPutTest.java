package _IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import _CommonTest.TestTimeUtil;

public class BufferedInputOutPutTest {
	public static void main(String[] args) throws Exception {
		Class clazz = BufferedInputOutPutTest.class;
		Method method = clazz.getMethod("bufferInput", null);
		Method method2 = clazz.getMethod("bufferInput2", null);
		TestTimeUtil.showtime(BufferedInputOutPutTest.class,method);
		TestTimeUtil.showtime(BufferedInputOutPutTest.class,method2);
	}
	public static void bufferInput() throws Exception {
		File f = new File(".//test");
		InputStream is = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] buff = new byte[1024];
		int len = 0; 
		StringBuffer buffer = new StringBuffer();
		while((len = bis.read(buff,0,1024))!=-1) {
			buffer.append(new String(buff));
		}
		bis.close();
	}
	public static void bufferInput2() throws Exception {
		File f = new File(".//test");
		InputStream is = new FileInputStream(f);
		byte[] buff = new byte[1024];
		int len = 0;
		StringBuffer buffer = new StringBuffer();
		while((len = is.read(buff))!=-1) {
			buffer.append(new String(buff));
		}
		is.close();
	}
	
}

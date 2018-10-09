package _IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadWriteTest {
	public static void main(String[] args) throws Exception {
		write();read();
	}
	
	public static void read() throws Exception {
		File f = new File(".//test");
//		FileReader reader = new FileReader(f);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(f),"utf-8");
		char[] cbuf = new char[1024];
		int len = 0;
//		while((len = reader.read(cbuf))!=-1) {
//			System.out.println(new String(cbuf));
//		}
		
		BufferedReader br = new BufferedReader(reader);
		String str = "";
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
	}
	
	public static void write() throws Exception {
		File f = new File(".//test");
		FileWriter writer = new FileWriter(f);
//		for (int i = 0; i < 1000; i++) {
//			writer.write(i+"\r\n");
//		}
//		writer.close();
		BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"utf-8"));
		for (int i = 0; i < 1000; i++) {
			bwriter.write("哈哈"+i+"\r\n");
		}
		bwriter.close();
	}
	
}

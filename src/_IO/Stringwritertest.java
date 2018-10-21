package _IO;

import java.io.RandomAccessFile;
import java.io.StringWriter;

public class Stringwritertest {
	public static void main(String[] args) {
		out();
	}
	public static void out() {
		StringWriter writer = new StringWriter();
		writer.write("abcdefghijklmnopqrstuvwxyz1234567890");
		String string = writer.toString();
		System.out.println(string);
		
		
	}
}

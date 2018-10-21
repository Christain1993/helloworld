package _IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) throws Exception {
		out();
	}
	public static void out() throws Exception {
		File f = new File(".//test");
		PrintStream ps = new PrintStream(new FileOutputStream(f));
		for (int i = 0; i < 100; i++) {
			ps.println(i);
		}
		ps.close();
		
	}
}

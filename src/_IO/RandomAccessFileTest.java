package _IO;

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class RandomAccessFileTest {
	public static void main(String[] args) throws Exception {
		test1();
	}
	
	public static void test1() throws Exception {
		RandomAccessFile  fa = new RandomAccessFile(".//test", "rw");
		
		fa.seek(100);
		byte[] bbuf = new byte[8];
		int len = 0;
		while((len = fa.read(bbuf))!=-1) {
			System.out.println(new String(bbuf));
		}
		
		fa.seek(fa.length());
		fa.write("1234567890".getBytes());
		fa.writeUTF("asdfghh");
		
		fa.close();
		
	}
}

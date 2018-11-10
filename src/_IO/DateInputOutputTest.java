package _IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DateInputOutputTest {
	public static void main(String[] args) throws Exception {
//		output();
		datainput();
	}
	public static void datainput() throws Exception {
		File f = new File(".//test");
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		short len = 0;
		while((len = dis.readShort())!=-1) {
			System.out.println((char)len);
		}
		dis.close();
	}
	public static void output() throws Exception {
		File f = new File(".//test");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
		for (int i = 0; i < 100; i++) {
			dos.writeInt(i);
		}
		dos.close();
	}
}

package _IO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthSpinnerUI;

import _Model.Student;

public class ByteIntOutPutTest {
	public static void main(String[] args) throws IOException, Exception {
		output();
	}
	public static void output() throws Exception, IOException {
		File f = new File(".//test");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (int i = 0; i < 100 ; i++) {
			String str = "参数"+i+"\r\n";
			bos.write(str.getBytes());
		}
		bos.writeTo(new FileOutputStream(f));
		byte[] byteArray = bos.toByteArray();
		for (byte b : byteArray) {
			System.out.println(b);
		}
		Student s = new Student();
		s.setId(1223L);
	}
	
	public static void input() {
		File f = new File(".//test");
		
	}
}

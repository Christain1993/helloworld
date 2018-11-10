package _IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOUtils {
	public static void save(String name, String value) throws Exception {
		File file = new File(".//",name);
		FileOutputStream output = new FileOutputStream(file);
		try {
			output.write(value.getBytes());
			output.flush();
		} finally {
			output.close();
		}
	}
	
	public static String read(String name) throws Exception {
		File file = new File(".//",name);
		FileInputStream input = new FileInputStream(file);
		try {
			int available = input.available();
			byte[] bytes = new byte[available];
			input.read(bytes);
			return new String(bytes);
		} finally {
			input.close();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		save("1212", "1212");
	}
}

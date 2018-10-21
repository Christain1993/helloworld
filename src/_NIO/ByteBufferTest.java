package _NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
	public static void main(String[] args) throws Exception {
		write();
		read();
		copy();
	}

	public static void write() throws Exception {
		File f = new File(".//test");
		FileOutputStream fos = new FileOutputStream(f);
		FileChannel channel = fos.getChannel();
		String str = "";
		ByteBuffer buffer = ByteBuffer.allocate(2);
		for (int i = 0; i < 100; i++) {
			str = i + "";
			buffer.put(str.getBytes());
			buffer.flip();
			channel.write(buffer);
			buffer.clear();
		}
		channel.close();
		fos.close();
	}

	public static void read() throws Exception {
		File f = new File(".//test");
		FileInputStream fis = new FileInputStream(f);
		FileChannel channel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(16);
		int read = 0;
		while (channel.read(buffer) != -1) {
			buffer.flip();
			System.out.println(new String(buffer.array()));
			buffer.clear();
		}
	}

	public static void copy() throws Exception {
		FileInputStream fis = new FileInputStream(new File(".//test"));
		FileOutputStream fos = new FileOutputStream(new File(".//test2"));
		FileChannel channel = fis.getChannel();
		FileChannel channel2 = fos.getChannel();
		channel.transferTo(100, channel.size(), channel2);
		
	}

	
}

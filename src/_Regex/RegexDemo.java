package _Regex;

import _IO.IOUtils;

public class RegexDemo {

	// 特别要注意的是如果有 "{ 的正则, 要使用 \"\\{ 的形式,
	public static void main(String[] args) throws Exception {
		String read = IOUtils.read("test");
		read = read.replaceAll("\"\\[", "{");
		System.out.println(read);

	}
}

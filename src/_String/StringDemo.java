package _String;

public class StringDemo {
	public static void main(String[] args) {
//		test();
		test2();
	}
	public void test() {
		String str= "21";
		int len = str.length() > 5 ? 5 : str.length();
		String substring = str.substring(0, len);
		System.out.println(substring);
	}
	public static void test2() {
		String s= "1,2,3,,,";
		System.out.println(s.contains(""));
	}
}	

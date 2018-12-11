package _OverLoad;

public class OverLoadTest {
	public void test(Object ...obj) {
		System.out.println("2312");
	}
	public void test(String str , Object ...obj) {
		System.out.println("weqwe");
		
	}

	public static void main(String[] args) {
		new OverLoadTest().test(1,"32");
	}
}

package _Reflection;

public class Son extends Humman implements Parents{
	public String age;
	@Override
	public String take(String str) {
		System.out.println(str);
		return str;
	}
	
}

package _Reflection;

public class Girl extends Humman implements Parents{
	public String age;
	@Override
	public Integer take(String str) {
		System.out.println("haha"+str);
		return 1;
	}
	
}

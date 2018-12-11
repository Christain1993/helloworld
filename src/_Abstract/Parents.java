package _Abstract;


public class Parents extends Humman implements Animal{
	public String address;
	class Son extends Parents{
		
	}
	class Girl extends Parents{
		
	}
	public static void main(String[] args) {
//		Son son = new Parents().new Son();
//		son.address = "1";
//		Girl girl = new Parents().new Girl();
//		girl.address = "2";
//		System.out.println(son.address);
//		System.out.println(girl.address);
		Humman h = new Parents();
		h.dosleep();
	}
	@Override
	public void eat() {
		
	}
	@Override
	public void sleep() {
		System.out.println("家长很晚才睡觉");
	}
}

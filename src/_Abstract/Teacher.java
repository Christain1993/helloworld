package _Abstract;

public abstract class Teacher {
	public void teach() {
		System.out.println("老师教书");
		teachself();
	}
	public abstract void teachself();
	public static void main(String[] args) {
		Teacher t =  new Student();
		t.teach();
	}
}

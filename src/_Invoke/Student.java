package _Invoke;

public class Student implements Person{
	private String name ;
	private Integer age ;
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void show() {
		System.out.println(this.name+this.age);
	}
}

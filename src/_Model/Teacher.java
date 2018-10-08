package _Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import _Jackson.JsondataFormatDeserialize;
import _Jackson.JsondataFormatSerialize;

@JacksonXmlRootElement(localName = "Teacher")
public class Teacher implements Serializable{
	
	private static final long serialVersionUID = -2252035700297532377L;
	@JsonIgnore
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private String name ;
	private Integer age;
	@JsonSerialize(using=JsondataFormatSerialize.class)
	@JsonDeserialize(using=JsondataFormatDeserialize.class)
	private Timestamp birthday;
	@JacksonXmlElementWrapper(localName = "asb",useWrapping= false)
	private List<Student> students;
	
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public Teacher() {
		super();
	}
	public Teacher(Long id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", students="
				+ students + ", student=" + student + "]";
	}
	
	
}

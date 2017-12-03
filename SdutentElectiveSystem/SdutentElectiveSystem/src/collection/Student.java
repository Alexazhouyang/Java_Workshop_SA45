package collection;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	public Set courses;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new HashSet();
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

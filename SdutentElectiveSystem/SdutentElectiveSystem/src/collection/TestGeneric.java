package collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	/**
	 * Generic Course
	 */
	public List<Course> courses;

	public TestGeneric() {
		super();
		this.courses = new ArrayList<Course>();
	}
	
	/**
	 * can not use basic type
	 */
	public void testBasicType() {
		//a new list which type is int
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("basic type package:"+list.get(0));
	}
	
	/**
	 * can use sub-generic object
	 */
	public void testChild(String id,String name) {
		ChildCourse childCourse = new ChildCourse();
		System.out.println("this is from child!");
		childCourse.setId(id);
		childCourse.setName(name);
		courses.add(childCourse);
		
		
	}
	/**
	 * Add
	 * @param args
	 */
	public void testAdd(String id,String name) {
		Course course1 = new Course(id, name);
		courses .add(course1);			
	}
	
	/**
	 * loop traverse(遍历)
	 * @param args
	 */
	public void testForEach() {
		for (Course course : courses) {
			System.out.println("course"+course.getId()+": ["+course.getName()+"]");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

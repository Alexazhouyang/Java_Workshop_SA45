package collection;

import java.util.ArrayList;
import java.util.List;

public class SetTest {
	public List<Course> coursesToSelect;

	public SetTest() {
		super();
		this.coursesToSelect = new ArrayList<Course>();
	}
	/**
	 * Add
	 * @param args
	 */
	public void testAdd(String id,String name) {
		Course course1 = new Course(id, name);
		coursesToSelect .add(course1);			
	}
	/**
	 * loop traverse(遍历)
	 * @param args
	 */
	public void testForEach() {
		for (Course course : coursesToSelect) {
			System.out.println("course"+course.getId()+": ["+course.getName()+"]");
		}
	}
	
	/**
	 * add courses to the student
	 */

}

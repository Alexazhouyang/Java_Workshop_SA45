package collection;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class ListTest  {
	/**
	 * to store the selective courses
	 */
	public List coursesToSelect;

	public ListTest() {
		super();
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 * to remove
	 */
	public void testRemove(int where) {
		Course temp1 = (Course) coursesToSelect.get(where);
		System.out.println("you will remove this course:"+temp1.getId()+" ["+temp1.getName()+"]");
		coursesToSelect.remove(where);
		
	}
	
	/**
	 * to modify 
	 */
	public void testModify(int where,String id,String name) {
		coursesToSelect.set(where, new Course(id, name));
	}
	
	
	/**
	 * by for each
	 */
	public void testForeach() {
		System.out.println("Access by for each: ");
		for (Object object : coursesToSelect) {			
			Course temp1 = (Course) object;
			System.out.println("course"+temp1.getId()+": ["+temp1.getName()+"]");
		}
	}
	
	/**
	 * by iterator to access
	 */
	
	public void testIterator() {
		Iterator iterator = coursesToSelect.iterator();
		System.out.println("Access by iterator: ");
		while (iterator.hasNext()) {
			Course temp1  = (Course) iterator.next();
			System.out.println("course"+temp1.getId()+": ["+temp1.getName()+"]");
			
			
		}
	}
	
	/**
	 * to add courses
	 */
	public void testAdd(String id,String name) {
		// add by single
//		Course course1 = new Course("1","English");
//		coursesToSelect.add(course1);
//		
		//add by group
//		Course[] courses = {new Course("1000", "English"),new Course("1002", "Math"),new Course("1003", "Chinese"),new Course("1004", "Java")};
//		coursesToSelect.addAll(0,Arrays.asList(courses));
				
//		Course temp = (Course) coursesToSelect.get(0);	
		
		Course course1 = new Course(id,name );
		coursesToSelect.add(course1);
//		System.out.println("have added course:");
//		testGet();
		
		
		
	}
	
	/**
	 * get elements in the list
	 * @param args
	 */
	public void testGet() {
		int size = coursesToSelect.size();
//		System.out.println(size);
		for (int i = 0; i < size; i++) {
			Course temp1 = (Course) coursesToSelect.get(i);
			System.out.println("course"+temp1.getId()+": ["+temp1.getName()+"]");			
		}
	}
	

}

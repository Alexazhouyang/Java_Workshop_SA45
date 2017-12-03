package collection;

import java.util.Scanner;

public class userface  {

	public static void main(String[] args) {
		
//			ListTest listTest = new ListTest();
//			listTest.testAdd("1000","English");
//			listTest.testAdd("1001","English1");
//			listTest.testAdd("1002","Englis2");
//		listTest.testAdd("1001","English1");
//			listTest.testGet();
//			listTest.testIterator();
//			listTest.testModify(1, "1004", "Math");
//			listTest.testForeach();
//			listTest.testRemove(1);
//			listTest.testGet();
		
		/**
		 * GENERIC
		 
			TestGeneric tGeneric = new TestGeneric();
			tGeneric.testAdd("1000","English");
			tGeneric.testAdd("1001","English1");
			tGeneric.testAdd("1000","English");
			tGeneric.testForEach();
			tGeneric.testChild("1002","Math");
			tGeneric.testForEach();
			tGeneric.testBasicType();
			*/
		SetTest sTest = new SetTest();
		sTest.testAdd("1000","English");
		sTest.testAdd("1001","Math");
		sTest.testAdd("1002","Chinese");
		sTest.testAdd("1003","PE");
		sTest.testAdd("1004","Economic");
		sTest.testAdd("1005","Physic");
		Student student = new Student("1", "Alexa");
		Scanner console = new Scanner(System.in);
		
		
	}

}

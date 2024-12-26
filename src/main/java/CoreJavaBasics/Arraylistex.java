package CoreJavaBasics;

import java.util.ArrayList;

public class Arraylistex {

	public static void main(String[] args) {
		//can accept duplicate values
		//can be defined as ordered list
		//arraylist defines array size as array.size
		//for array it will be array.length
		
		
		int x[] = new int[5]; // array fixed size
		
		ArrayList<String> a = new ArrayList<String>(); // Arraylist class is the Java collections, having dynamic length and size.
		a.add("Raj"); 
		a.add("Tina");
		a.indexOf("raj");
		a.contains("testing");
		//System.out.println(a.contains("testing"));
		a.remove(1);
		a.add(0,"QA");
		a.size();
		//System.out.println(a);
		System.out.println(a.size());
		
		for(int i=0;i< a.size();i++) {
			 System.out.println("index is "+i+"value is "+a.get(i));
			
		}
	}

}

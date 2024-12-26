package CoreJavaBasics;

import java.util.HashSet;
import java.util.Iterator;

public class hashsetex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("rose");
		hs.add("tulip");
		hs.add("lotus");
		System.out.println(hs);
		hs.remove("tulip");
		System.out.println(hs);
		Iterator<String> i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
			
		}
		

	}

}

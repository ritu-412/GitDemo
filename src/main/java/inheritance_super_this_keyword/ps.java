package inheritance_super_this_keyword;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ps {
	
	@BeforeMethod
	public void startpoint() {
		System.out.println("Execute me first");
	}


	public void firstmethod() {
		
		System.out.println("Do this inside the method");
		
	}
	
	@AfterMethod
	public void endpoint() {
		System.out.println("Execute me last");
	}
	
	
	

}

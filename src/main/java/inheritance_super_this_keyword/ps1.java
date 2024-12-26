package inheritance_super_this_keyword;
import org.testng.annotations.Test;

public class ps1 extends ps {

	int a;
	//int b;
	
   @Test
   public void Runtestcases() {
	firstmethod();
	ps2 ps2 = new ps2(4);
	ps2.increament();
	ps2.decreament();
	ps2.multiply();
	
   }
   

}

package CoreJavaBasics;

public class exceptionhandling {
	
	//catch block must follow after try block
	//whether ot not the code executes finally block must execute.
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=10;
		int y=0;
				
		try {
			int z = x/y;
			System.out.println(z);
			
			
		} catch(ArithmeticException e) {
			System.out.println("Arithmetic exception occures");		
			
		}
		
		catch(Exception e) {
			System.out.println("Error occurs");			
		}
		finally {
			System.out.println("The finally block excutes");		
			
		}
		
		

	}

}

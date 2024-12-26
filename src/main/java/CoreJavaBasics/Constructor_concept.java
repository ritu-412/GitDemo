package CoreJavaBasics;

public class Constructor_concept {
	
	public Constructor_concept(){
		
	System.out.println("Default Constructor invoked");
	//default constructor
	}
	public Constructor_concept(String s){
		
		System.out.println("Parametrized Constructor invoked");
		
		//default constructor
		}

	public Constructor_concept(int x, int y){
		
		System.out.println("Parametrized Constructor invoked");
		int z = x+y;
		System.out.println("summation is : "+ z);
		//default constructor
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Constructor_concept cc =new Constructor_concept();
		//Constructor_concept cc1 =new Constructor_concept("hello");
		Constructor_concept cc2 = new Constructor_concept(4,5);
		
	}

}

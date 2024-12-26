package CoreJavaBasics;

public class statickeyword {
	
	String name; //instance variable
	String address;
	static int age; //class variable
	static int pin;
	
	static {
		 age = 26;
		 pin = 700211; //static block
	}
	
	public void getData() {
		
		System.out.println("Hello");
		
	}
	
	public static void getaddress() {
		
		System.out.println("static method"+" "+age);
	}
	
	public statickeyword(String name,String address) {
		
		System.out.println(name+" "+address+" "+statickeyword.age+" "+statickeyword.pin);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		statickeyword sk = new statickeyword("raj","Kolkata");
		statickeyword sk1 = new statickeyword("ram","bglr");
		sk.getData();
		statickeyword.getaddress();
		

	}

}

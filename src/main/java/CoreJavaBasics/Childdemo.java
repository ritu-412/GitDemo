package CoreJavaBasics;

public class Childdemo extends Parentdemo{

	String name = "Ritu";
	
	//Method definetion
	public void getData() {
		
		System.out.println(name+"1");
		System.out.println(super.name+"1");
		super.getData();
		
	}
	//constructor definetion
	public Childdemo() {
		super();
		System.out.println(name +" comes from constructor");
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Childdemo cd = new Childdemo();
	cd.getData();

	}

}

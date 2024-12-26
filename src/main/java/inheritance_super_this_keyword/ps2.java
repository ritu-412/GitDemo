package inheritance_super_this_keyword;

public class ps2 extends ps3 {

	int a;
	
	public ps2(int a) {
		super(a);
		this.a = a;
	}
	
	
	public int increament() {	
		a=a+1;
		System.out.println("Summation is"+ +a);
		return a;
	}

	public int decreament() {	 
		int a=4;
		a=a-1;
		System.out.println("deduction is"+ +a);
		return a;
	}

	


}

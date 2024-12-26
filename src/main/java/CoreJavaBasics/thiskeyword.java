package CoreJavaBasics;

public class thiskeyword {
	
	int x = 10;
	
	public void getData() {
		
		int x = 5;
		System.out.println(x);
		System.out.println("example this keyword"+" "+this.x);
		int sum = x+this.x;
		System.out.println("sum is"+" "+this.x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		thiskeyword td = new thiskeyword();
		td.getData();

	}

}

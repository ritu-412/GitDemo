package welcomebranchgit;

public class demobranch {

	public static void main(String[] args) {
		System.out.println("Hello");
		String originaltext ="Welcome";
		
		String revstring = "";
		
		for (int i =originaltext.length()-1; i>=0 ;i--) {
			
			String revstring1  = revstring + originaltext.charAt(i);
			System.out.print(revstring1);
		}
		

	}

}

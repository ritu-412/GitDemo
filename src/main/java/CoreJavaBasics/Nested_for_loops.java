package CoreJavaBasics;

public class Nested_for_loops {
	/**********
	 * 1
	 * 2 3
	 * 4 5 6
	 * 7 8 9 10 
	 * 
	 ** @param args
	 */
	public static void main(String[] args) {
		int k=1; //2
		for (int i=1; i<5;i++) { //3

			for (int j=1;j<=i;j++) { 

				System.out.print(k);
				System.out.print("\t");
				k++;
			}

			System.out.println("");

		}

	}

}

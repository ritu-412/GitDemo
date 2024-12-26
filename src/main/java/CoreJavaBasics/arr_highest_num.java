package CoreJavaBasics;

public class arr_highest_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,35,45};
		
		int maxvalue = arr[0];
		//num variable represents one by one value that comes from main array.
		for(int num : arr) { 
			if(num > maxvalue) {

				maxvalue = num;
			}

		}
		System.out.println(maxvalue);
		arr_highest_num arr_hm = new arr_highest_num();
		arr_hm.reverse_string();

	}


	public String reverse_string() {

		String original = "Hello";
		String reverse = "";

		for(int i = original.length()-1; i>=0; i--) {
			reverse = reverse+original.charAt(i);
		}
		System.out.println(reverse);
		return reverse;

	}



}



package JavaStreams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	@Test	
	public void javasteams_practice() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijit");
		names.add("David");
		names.add("Rohit");
		names.add("Anshikha");
		names.add("Ram");

		//Long count = names.stream().filter(s->s.startsWith("A")).count(); // founds the count
		//System.out.println(count);

		//System.out.println(names.stream().findAny());

		//names.stream().filter(s->s.length()>3).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//filter the string whose length greater than 3 and make those to uppercase.
		//names.stream().forEach(s->System.out.println(s)); //to print all the names in the List
		//names.stream().filter(s->s.startsWith("A")).filter(s->s.length()>7).forEach(s->System.out.println(s));
		//To print any name startswith A and whose length is >7, can be used both with filter and map
	}


	@Test
	public void javasteams_practice1() {
		String[] arr = {"Man","Woman"};
		List<String> gender = Arrays.asList(arr); //convert array to List.

		ArrayList<String> names = new ArrayList<String>();
		names.add("Raj");
		names.add("Tina");
		names.add("Rohit");
		names.add("Tom");
		names.add("David");
		System.out.println("From the second Testcases----------------------------------");
		Stream<String> newstream = Stream.concat(gender.stream(), names.stream());
		newstream.sorted().forEach(s->System.out.println(s)); // concatenate two strings and print the result.
		Boolean checkname = newstream.allMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(checkname);

	}

	
	@Test
	public void print_uniquenumbers() {
		Integer[] arr = {1,2,2,3,4,4,5,5,6,7,8};
		List <Integer> number1 = Arrays.asList(arr); //convert array to List.
		number1.stream().distinct().forEach(s->System.out.println(s));	//print unique numbers
		List<Integer> li = number1.stream().distinct().sorted().collect(Collectors.toList());
	    //form a new collections of list and give the output with unique and sorted array new array
		System.out.println(li.get(2));
		
	}
	
	
	

}
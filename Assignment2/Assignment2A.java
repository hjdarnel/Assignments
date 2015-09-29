//Name:
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment2A tester = new Assignment2A();
//		String a = tester.makePalindrome("abb");
//		System.out.println(a);
		boolean b = tester.isPalindrome("racecar");
		System.out.println(b);
		
	}
	
//	public String makePalindrome(String input) {
//		
//	}
	public boolean isPalindrome(String input) {
		String temporary = "";
		
		for (int k = input.length() -1; k >= 0; k--){
			temporary += input.charAt(k);
		}
		
		if (temporary.equals(input))
			return true;
		return false;
	}


}
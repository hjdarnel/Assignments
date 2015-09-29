//Name: Henry Darnell
//ID: 010646670
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment2A tester = new Assignment2A();
		String a = tester.makePalindrome("fg");
		System.out.println(a);
		
		String b = tester.makePalindrome("ababba");
		System.out.println(b);
		
		String c = tester.makePalindrome("reviver");
		System.out.println(c);
	}
	
	public String makePalindrome(String input) {
		String pal = input;	
		String temp;
		if(isPalindrome(input))
			return input;
		for (int i = 1; i < input.length(); i++){
			temp = new StringBuilder(input.substring(0, i)).reverse().toString();
			
			if(isPalindrome(pal + temp)){
				pal += temp;
				break;
			}
		}
		return pal;
	}
	public static boolean isPalindrome(String input) {
		String temporary = "";
		
		for (int k = input.length() -1; k >= 0; k--){
			temporary += input.charAt(k);
		}
		
		if (temporary.equals(input)){
			return true;
		}
		return false;
	}


}


// Name: Henry Darnell
// ID: 010646670

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment2B {
    static HashSet<String> subStrings;

    public static void main(String[] args) {
       Assignment2B tester = new Assignment2B();
        int i = tester.numPalindrome("racecar");
        System.out.println(subStrings.toString());
        System.out.println(i);
    }

    public int numPalindrome(String input) {
        getSubStrings(input);

        int counter = 0;
        for(String z : subStrings){
            if(isPalindrome(z))
               counter++;
        }

        return counter;
    }

    private static void getSubStrings(String input){
        subStrings = new HashSet<String>();

        for(int i = 0; i < input.length(); i++) {
            for(int k = 1; k <= input.length() - i; k++)
                subStrings.add(input.substring(i, k + i));
        }
    }

    public static boolean isPalindrome(String input) {
        String temporary = "";

        //Reverse input, store in temporary
        for (int k = input.length() -1; k >= 0; k--){
            temporary += input.charAt(k);
        }

        //if input backwards == input, input is a palindrome
        if (temporary.equals(input)){
            return true;
        }
        //otherwise it's not
        return false;
    }
}
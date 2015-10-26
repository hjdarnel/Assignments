// Name: Henry Darnell
// ID: 010646670

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment3B {

    public static void main(String[] args){
        Assignment3B tester = new Assignment3B();

        int[] sequence = {9, 25, 25};
        System.out.println(tester.numStep(sequence));

    }
    public int numStep(int[] sequence) {
        // your code here
        if(isPalindrome(sequence))
            return 0;

        return 0;
    }

    public boolean isPalindrome(int[] sequence){

        for(int i = 0; i < sequence.length / 2; i++){
            if(sequence[i] != sequence[sequence.length - 1- i])
                return false;
        }
        return true;
    }
}


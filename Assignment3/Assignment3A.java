// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment3A {

    public static void main(String [ ] args){
        Assignment3A tester = new Assignment3A();
        System.out.println(tester.numPaint("BBBWWWBWWWBWWBBBWWBBBWB"));
        System.out.println(tester.numPaint("BWBBWBBWBBBBBBBWBBWBWBWBBBBBBBBBBBBBBBBBWBBBBBBBBB"));
        System.out.println(tester.numPaint("WBBWWBWWWWWBWWBBBWBWWBWBBBWWBWBWBBBWBBBBWBWWBWWBWB"));
    }



    public int numPaint(String input) {
        int numB = 0;
        int numW = 0;

        int index = input.indexOf('W'); //index of first W

        //Find B in the remaining substring / ++ when found
        for(int i = index; i < input.length(); i++){
            if(input.charAt(i) == 'B')
                numB++;
        }

        //Find W in the remaining substring / ++ when found
        index = input.lastIndexOf('B');
        for(int i = index; i >=  0;  i--){
            if(input.charAt(i) == 'W')
                numW++;
        }


        System.out.println("NumB " + numB);
        System.out.println("NumW " + numW);

        if(numB > numW)
            return numW;
        else
            return numB;
    }
}


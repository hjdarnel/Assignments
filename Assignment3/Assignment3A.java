// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment3A {

    public static void main(String [ ] args){
        Assignment3A tester = new Assignment3A();

        long startTime = System.currentTimeMillis();
        System.out.println(tester.numPaint("BBBWWWBWWWBWWBBBWWBBBWB"));

        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();
        System.out.println(tester.numPaint("BWBBWBBWBBBBBBBWBBWBWBWBBBBBBBBBBBBBBBBBWBBBBBBBBB"));

        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();
        System.out.println(tester.numPaint("WBBWWBWWWWWBWWBBBWBWWBWBBBWWBWBWBBBWBBBBWBWWBWWBWB"));

        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");

    }



    public int numPaint(String input) {
        ArrayList<Integer> sums = new ArrayList<Integer>();


        for(int i = 0; i < input.length(); i++){

            int tempB = 0;
            int tempW = 0;
            for(int k = i; k >= 0; k--){
                if(input.charAt(k) == 'W')
                    tempW++;
            }
            for(int k = i + 1; k < input.length(); k++){
                if(input.charAt(k) == 'B')
                    tempB++;
            }
            sums.add(tempB + tempW);
        }
        int min = Collections.min(sums);

        return min;
    }
}


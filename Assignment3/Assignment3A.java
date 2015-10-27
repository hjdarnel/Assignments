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
        List<Integer> sums = new ArrayList();


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
//        System.out.println(sums);
        int min = Collections.min(sums);

        return min;
    }
}


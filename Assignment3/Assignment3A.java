// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment3A {

    public static void main(String [ ] args){
        Assignment3A tester = new Assignment3A();
        System.out.println(tester.numPaint("BBWWW"));
        System.out.println(tester.numPaint("BWBWB"));
        System.out.println(tester.numPaint("WWWWBBB"));
    }



    public int numPaint(String input) {
        int num = 0;
        int index = 0; //index of first W
        //find first W
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'W') {
                index = i;
                break;
            }
        }

        //Find B in the remaining substring / ++ when found
        for(int i = index; i < input.length(); i++){
            if(input.charAt(i) == 'B')
                num++;
        }

        return num;
    }
}


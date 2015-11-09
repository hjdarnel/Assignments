// Name: Henry Darnell
// ID: 010646670

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment4A {
//testing
    boolean DEBUG = true;

    public static void main(String[] args) {
        Assignment4A tester = new Assignment4A();

        String[] input = {"2 90 90", "90 2 90", "90 90 2"};
        System.out.println(tester.minPrice(input));

        String[] input2 = {"5 100 100", "100 100 100", "5 100 100"};
        System.out.println(tester.minPrice(input2));

        String[] input3 = {"30 44 87", "53 64 61", "17 93 103"};
        System.out.println(tester.minPrice(input3));


    }

    public int minPrice(String[] tiles) {
        //Copy string array into an int array costs[tile][color]
        int[][] costs = new int[tiles.length][3];
        for(int i = 0; i < tiles.length; i++){
            costs[i][0] = Integer.parseInt(tiles[i].split(" ")[0]);
            costs[i][1] = Integer.parseInt(tiles[i].split(" ")[1]);
            costs[i][2] = Integer.parseInt(tiles[i].split(" ")[2]);
        }

        if(DEBUG)
            System.out.println(Arrays.deepToString(costs));
        return 0;
    }
}


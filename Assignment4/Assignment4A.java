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
        System.out.println("Price: " +tester.minPrice(input));
        System.out.println("--------------------------------");

        String[] input2 = {"5 100 100", "100 100 100", "5 100 100"};
        System.out.println("Price: " +tester.minPrice(input2));
        System.out.println("--------------------------------");

        String[] input3 = {"30 44 87", "53 64 61", "17 93 103"};
        System.out.println("Price: " +tester.minPrice(input3));
        System.out.println("--------------------------------");

        String[] input4 = {"2 4 6", "1 1 1", "4 2 6"};
        System.out.println("Price: " +tester.minPrice(input4));
        System.out.println("--------------------------------");



    }

    public int minPrice(String[] tiles) {
        //Copy string array into an int array costs[tile][color]
        int[][] costs = new int[tiles.length][3];
        int[] paint = new int[tiles.length]; //0 is black, 1 is grey, 2 is white. Side by side cannot be the same number
        List<Integer> sums = new ArrayList<Integer>();
        int mostRecentTileColor = 0;
        int currentColoringCost = 0;

        for(int i = 0; i < tiles.length; i++){
            costs[i][0] = Integer.parseInt(tiles[i].split(" ")[0]);
            costs[i][1] = Integer.parseInt(tiles[i].split(" ")[1]);
            costs[i][2] = Integer.parseInt(tiles[i].split(" ")[2]);
        }

        if(DEBUG) System.out.println(Arrays.deepToString(costs));


        for(int k = 0; k < tiles.length; k++) { //this is our iterator for starting the coloring
            for (int i = k; i < tiles.length; i++) {
                if (i == 0) {
                    if (costs[0][0] < costs[0][1]) {
                        paint[0] = 0;
                        currentColoringCost += costs[0][0];
                    } else if (costs[0][2] < costs[0][1] && paint[0 - 1] != 2) {
                        paint[0] = 2;
                        currentColoringCost += costs[0][2];
                    } else {
                        paint[0] = 1;
                        currentColoringCost += costs[0][1];
                    }
                } else {
                    if (costs[i][0] < costs[i][1] && paint[i - 1] != 0) {
                        paint[i] = 0;
                        currentColoringCost += costs[i][0];
                    } else if (costs[i][2] < costs[i][1] && paint[i - 1] != 2) {
                        paint[i] = 2;
                        currentColoringCost += costs[i][2];
                    } else {
                        paint[i] = 1;
                        currentColoringCost += costs[i][1];
                    }
                }
                if (DEBUG) System.out.println("Cost after tile " + i + " is " + currentColoringCost + ".");
            }
            for(int j = 0; j < k; j++){
                if (j == 0) {
                    if (costs[0][0] < costs[0][1]) {
                        paint[0] = 0;
                        currentColoringCost += costs[0][0];
                    } else if (costs[0][2] < costs[0][1] && paint[0 - 1] != 2) {
                        paint[0] = 2;
                        currentColoringCost += costs[0][2];
                    } else {
                        paint[0] = 1;
                        currentColoringCost += costs[0][1];
                    }
                } else {
                    if (costs[j][0] < costs[j][1] && paint[j - 1] != 0) {
                        paint[j] = 0;
                        currentColoringCost += costs[j][0];
                    } else if (costs[j][2] < costs[j][1] && paint[j - 1] != 2) {
                        paint[j] = 2;
                        currentColoringCost += costs[j][2];
                    } else {
                        paint[j] = 1;
                        currentColoringCost += costs[j][1];
                    }
                }
                if (DEBUG) System.out.println("Cost after tile " + j + " is " + currentColoringCost + ".");

            }
            sums.add(currentColoringCost);
            currentColoringCost = 0;
        }


        return Collections.min(sums);
    }


}


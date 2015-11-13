// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment4A {

    public static void main(String[] args) {
        Assignment4A tester = new Assignment4A();

        long startTime = System.currentTimeMillis();
        String[] input = {"2 90 90", "90 2 90", "90 90 2"};
        System.out.println("Testing: " + Arrays.toString(input));
        System.out.println("Price: " +tester.minPrice(input));
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println("--------------------------------");

        startTime = System.currentTimeMillis();
        String[] input2 = {"5 100 100", "100 100 100", "5 100 100"};
        System.out.println("Testing: " + Arrays.toString(input2));
        System.out.println("Price: " +tester.minPrice(input2));
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println("--------------------------------");

        startTime = System.currentTimeMillis();
        String[] input3 = {"30 44 87", "53 64 61", "17 93 103"};
        System.out.println("Testing: " + Arrays.toString(input3));
        System.out.println("Price: " +tester.minPrice(input3));
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println("--------------------------------");

        startTime = System.currentTimeMillis();
        String[] input4 = {"2 3 4", "100 100 100", "53 63 73", "59 42 5", "52 52 46", "7 8 4"};
        System.out.println("Testing: " + Arrays.toString(input4));
        System.out.println("Price: " +tester.minPrice(input4));
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        System.out.println("--------------------------------");
    }

    public int minPrice(String[] tiles) {
        //Copy string array into an int array A[tile][color]
        int[][] A = new int[tiles.length][3];

        for(int i = 0; i < tiles.length; i++){
            A[i][0] = Integer.parseInt(tiles[i].split(" ")[0]);
            A[i][1] = Integer.parseInt(tiles[i].split(" ")[1]);
            A[i][2] = Integer.parseInt(tiles[i].split(" ")[2]);
        }

        int[] current = A[0];
        int[] next;

        for(int i = 1; i < A.length; i++){
            next = A[i];
            current = findMinPermutation(current, next);
        }
        return Math.min(current[2], Math.min(current[0], current[1]));
    }

    private int[] findMinPermutation(int[] first, int[] second){
        int[] toReturn = new int[3];

        toReturn[0] = Math.min(first[1] + second[0], first[2] + second[0]);
        toReturn[1] = Math.min(first[0] + second[1], first[2] + second[1]);
        toReturn[2] = Math.min(first[0] + second[2], first[1] + second[2]);

        return toReturn;
    }

}


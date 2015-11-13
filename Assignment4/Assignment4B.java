// Name: Henry Darnell
// ID: 010646670

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment4B {

    List<Integer> current;
    List<Integer> next;


    public static void main(String[] args) {
        Assignment4B tester = new Assignment4B();

        long startTime = System.currentTimeMillis();
        String[] input5 = {"B..FS",
                           "...FF",
                           "....."};
        System.out.println(tester.minTime(input5));
        long endTime = System.currentTimeMillis();
        System.out.println("Time to run: " + (endTime - startTime) / 1000.0 + " seconds");


        startTime = System.currentTimeMillis();
        String[] input1 = {"B", "S"};
        System.out.println(tester.minTime(input1));
        endTime = System.currentTimeMillis();
        System.out.println("Time to run: " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();
        String[] input2 = {"B..S..S",
                           ".B...BB",
                           ".S..S.."};
        System.out.println(tester.minTime(input2));
        endTime = System.currentTimeMillis();
        System.out.println("Time to run: " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();
        String[] input3 = {
                "...FFFF.",
                "B..FS...",
                "..FFFFF.",
                "........"
        };
        System.out.println(tester.minTime(input3));
        endTime = System.currentTimeMillis();
        System.out.println("Time to run: " + (endTime - startTime) / 1000.0 + " seconds");

        startTime = System.currentTimeMillis();
        String[] input4 = {
                "BBB..FS.S.S",
                "BBB..F.S.S.",
                "BB.........",
                "BB...FSSSSS"
        };

        System.out.println(tester.minTime(input4));
        endTime = System.currentTimeMillis();
        System.out.println("Time to run: " + (endTime - startTime) / 1000.0 + " seconds");

    }

    public int factorial(int n){
        int z = 1;
        for(int i = 1; i <= n; i++){
            z *= i;
        }
        return z;
    }

    public static void swap(int[] in, int a, int b){
        int tempA = in[a];
        int tempB = in[b];
        in[b] = tempA;
        in[a] = tempB;
    }

    public int minTime(String[] map) {
        int lineLength = map[0].length();
        List<Integer> bikes = new ArrayList<>();
        List<Integer> spaces = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[0].length(); k++) {
                if(map[i].charAt(k) == 'B')
                    bikes.add(i * lineLength + k);
                else if(map[i].charAt(k) == 'S')
                    spaces.add(i * lineLength + k);
            }
        }
        long startTime = System.currentTimeMillis();

        //This method for finding permutations was taken from https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        int n = bikes.size();
        int[][] bikesP = new int[factorial(n)][n];

        for (int i = 0; i < n; i++)
            bikesP[0][i] = bikes.get(i); // copy initial permutation to row 0

        for (int i = 1; i < bikesP.length; i++) {
            bikesP[i] = Arrays.copyOf(bikesP[i-1], n);
            int k, l;
            for (k = n - 2; bikesP[i][k] >= bikesP[i][k+1]; k--);
            for (l = n - 1; bikesP[i][k] >= bikesP[i][l]; l--);
            swap(bikesP[i], k, l);

            for (int j = 1; k+j < n-j; j++)
                swap(bikesP[i], k+j, n-j);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time for permutation: " + (endTime - startTime) / 1000.0 + " seconds");

        int sum;
        int minSum = 9999;

        startTime = System.currentTimeMillis();

        for(int i = 0; i < bikesP.length; i++){
            sum = 0;
            for (int k = 0; k < n; k++) {
                sum += search(map, bikesP[i][k] % lineLength, bikesP[i][k] / lineLength, spaces.get(k) % lineLength, spaces.get(k) / lineLength);
            }
            if(sum < minSum)
                minSum = sum;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time for search: " + (endTime - startTime) / 1000.0 + " seconds");

        return minSum;
    }

    public int search(String[] map, int sourceX, int sourceY, int destX, int destY){
        int lineLength = map[0].length();
        if(current == null) current = new ArrayList<>();
            else current.clear();
        if(next == null) next = new ArrayList<>();
            else next.clear();
        int aX;
        int aY;
        int counter = 1;

        boolean[] visited = new boolean[map.length * map[0].length() + 1];
        visited[sourceY * lineLength + sourceX] = true;

        current.add(sourceY * lineLength + sourceX);

        while(true) {
            for (Integer a : current) {
                aX = a % lineLength;
                aY = a / lineLength;

                if (aY - 1 >= 0 && ! visited[(aY - 1) * lineLength + aX])                                        //ABOVE
                    if (map[aY - 1].charAt(aX) == '.' || map[aY - 1].charAt(aX) == 'B') {
                        next.add((aY - 1) * lineLength + aX);
                        visited[(aY - 1) * lineLength + aX] = true;

                    } else if (map[aY - 1].charAt(aX) == 'S' && destX == aX && destY == aY - 1) {
                        return counter;

                    }

                if (aX - 1 >= 0 && !visited[(aY * lineLength) + aX - 1])                                        //LEFT
                    if (map[aY].charAt(aX - 1) == '.' || map[aY].charAt(aX - 1) == 'B') {
                        next.add((aY * lineLength) + aX - 1);
                        visited[(aY * lineLength) + aX - 1] = true;

                    } else if (map[aY].charAt(aX - 1) == 'S' && destX == aX -1 && destY == aY) {
                        return counter;
                    }

                if (aY + 1 < map.length && !visited[((aY + 1) * lineLength) + aX])                                //BELOW
                    if (map[aY + 1].charAt(aX) == '.' || map[aY + 1].charAt(aX) == 'B') {
                        next.add(((aY + 1) * lineLength) + aX);
                        visited[((aY + 1) * lineLength) + aX] = true;

                    } else if (map[aY + 1].charAt(aX) == 'S' && destX == aX && destY == aY + 1) {
                        return counter;
                    }

                if (aX + 1 < map[0].length() && !visited[(aY) * lineLength + aX + 1])                           //RIGHT
                    if (map[aY].charAt(aX + 1) == '.' || map[aY].charAt(aX + 1) == 'B' ) {
                        next.add((aY) * lineLength + aX + 1);
                        visited[(aY) * lineLength + aX + 1] = true;
                    } else if (map[aY].charAt(aX + 1) == 'S' && destX == aX + 1 && destY == aY) {
                        return counter;
                    }

            }

            if(next.isEmpty())
                return -1;
            counter++;
            current.clear();
            current.addAll(next);
            next.clear();
        }

    }
}



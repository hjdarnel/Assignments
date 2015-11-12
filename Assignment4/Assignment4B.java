// Name: Henry Darnell
// ID: 010646670

import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class Assignment4B {

    public static void main(String[] args) {
        Assignment4B tester = new Assignment4B();

        String[] input5 = {"...S", "....", ".B..", "...."};
        System.out.println(tester.minTime(input5));

//        String[] input1 = {"B..FS",
//                           "...FF",
//                           "....."};
//        System.out.println(tester.minTime(input1));
//
//        String[] input2 = {"B",
//                           "S"};
//        System.out.println(tester.minTime(input2));
//
//        String[] input3 = {"B..S..S",
//                           ".B...BB",
//                           ".S..S.."};
//        System.out.println(tester.minTime(input3));
//
//        String[] input4 = {"BBB..FS.S.S",
//                           "BBB..F.S.S.",
//                           "BB.........",
//                           "BB...FSSSSS"};
//        System.out.println(tester.minTime(input4));

    }

    public int minTime(String[] map) {
        return search(map, 1, 2, 0, 3);
    }

    public int search(String[] map, int sourceX, int sourceY, int destX, int destY){

        boolean isFound = false;
        int lineLength = map[0].length();
        List<Integer> current = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        int aX;
        int aY;
        int counter = 1;
        boolean[] visited = new boolean[map.length * map[0].length()];
        visited[sourceY * lineLength + sourceX] = true;


        current.add(sourceY * lineLength + sourceX);

        System.out.println("Starting source int index: " + current.toString());
        System.out.println("sourceX: " + sourceX + " sourceY: " + sourceY);
        System.out.println("LineLength: " + lineLength + "\n");

        while(!isFound) {
            for (Integer a : current) {
                aX = a % lineLength;
                aY = a / lineLength;

                if (aY - 1 >= 0 && ! visited[(aY - 1) * lineLength + aX])                                        //ABOVE
                    if (map[aY - 1].charAt(aX) == '.' || map[aY - 1].charAt(aX) == 'B') {
                        next.add((aY - 1) * lineLength + aX);
                        visited[(aY - 1) * lineLength + aX] = true;

                    } else if (map[aY - 1].charAt(aX) == 'S') {
                        isFound = true;
                        return counter;

                    }

                if (aX - 1 >= 0 && !visited[(aY * lineLength) + aX - 1])                                        //LEFT
                    if (map[aY].charAt(aX - 1) == '.' || map[aY].charAt(aX - 1) == 'B') {
                        next.add((aY * lineLength) + aX - 1);
                        visited[(aY * lineLength) + aX - 1] = true;

                    } else if (map[aY].charAt(aX - 1) == 'S') {
                        isFound = true;
                        return counter;
                    }

                if (aY + 1 < map.length && !visited[((aY + 1) * lineLength) + aX])                                //BELOW
                    if (map[aY + 1].charAt(aX) == '.' || map[aY + 1].charAt(aX) == 'B') {
                        next.add(((aY + 1) * lineLength) + aX);
                        visited[((aY + 1) * lineLength) + aX] = true;

                    } else if (map[aY + 1].charAt(aX) == 'S') {
                        isFound = true;
                        return counter;
                    }

                if (aX + 1 < map[0].length() && !visited[(aY) * lineLength + aX + 1])                           //RIGHT
                    if (map[aY].charAt(aX + 1) == '.' || map[aY].charAt(aX + 1) == 'B' ) {
                        next.add((aY) * lineLength + aX + 1);
                        visited[(aY) * lineLength + aX + 1] = true;
                    } else if (map[aY].charAt(aX + 1) == 'S') {
                        isFound = true;
                        return counter;
                    }

            }

            System.out.println("next " +  next.toString());
            counter++;
            current.clear();
            current.addAll(next);
            next.clear();
        }


        return counter;

    }
}

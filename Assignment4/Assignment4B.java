// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment4B {

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

        startTime = System.currentTimeMillis();
        String[] input6 = {".B.F...",
                           "...F..B",
                           "...F...",
                           "..SF.S."};

        System.out.println(tester.minTime(input6));
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

    public int[] swap(int[] in, int a, int b){
        int tempA = in[a];
        int tempB = in[b];
        in[b] = tempA;
        in[a] = tempB;
        return in;
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

        int[][] times = new int[bikes.size()][spaces.size()];

        for(int i = 0; i < bikes.size(); i++){
            for(int k = 0; k < spaces.size(); k++){
                times[i][k] = search(map, bikes.get(i) % lineLength, bikes.get(i) / lineLength, spaces.get(k) % lineLength, spaces.get(k) / lineLength);
            }
        }


        return findLowestTime(times);
    }

    public int findLowestTime(int[][] times){
        if(times.length == 1){
            return times[0][0];
        }
        int lineLength = times.length;
        int[] permutation = new int[lineLength];
        int min;

        for(int i = 0; i < lineLength; i++){
            permutation[i] = i;
        }
        min = sum(times, permutation);

        for(int i = 1; i <= factorial(times.length); i++) {
            min = Math.min(min, sum(times, permutation));
            permutation = nextPermutation(permutation, times.length);
        }

        return min;
    }

    public int sum(int[][] times, int[] permutation) {

        boolean broken = false;
        int sum = 0;

        for (int i = 0; i < times.length && !broken; i++) {

            if (times[i][permutation[i]] == -1)
                broken = true;
            else
                sum += times[permutation[i]][i];
        }
        return broken ? 10000 : sum;
    }

    //This method for finding permutations was taken from https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order

    public int[] nextPermutation(int[] last, int n){
        int[] toReturn = copy(last);
        int a = n - 2;
        int b = n - 1;
        while(toReturn[a] >= toReturn[a + 1] && a > 0){
            a--;
        }
        while(toReturn[a] >= toReturn[b] && b > 0){
            b--;
        }

        toReturn = swap(toReturn, a, b);

        for(int j = 1; a + j < n - j; j++)
            toReturn = swap(toReturn, a + j, n - j);

        return toReturn;
    }


    public int[] copy(int[] array){
        return Arrays.copyOf(array, array.length); }

    public int search(String[] map, int sourceX, int sourceY, int destX, int destY){
        int lineLength = map[0].length();
        List<Integer> current = new ArrayList<>();
        List<Integer> next = new ArrayList<>();

        int aX;
        int aY;
        int counter = 0;

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
                        counter++;
                        return counter;

                    }

                if (aX - 1 >= 0 && !visited[(aY * lineLength) + aX - 1])                                        //LEFT
                    if (map[aY].charAt(aX - 1) == '.' || map[aY].charAt(aX - 1) == 'B') {
                        next.add((aY * lineLength) + aX - 1);
                        visited[(aY * lineLength) + aX - 1] = true;

                    } else if (map[aY].charAt(aX - 1) == 'S' && destX == aX -1 && destY == aY) {
                        counter++;
                        return counter;
                    }

                if (aY + 1 < map.length && !visited[((aY + 1) * lineLength) + aX])                                //BELOW
                    if (map[aY + 1].charAt(aX) == '.' || map[aY + 1].charAt(aX) == 'B') {
                        next.add(((aY + 1) * lineLength) + aX);
                        visited[((aY + 1) * lineLength) + aX] = true;

                    } else if (map[aY + 1].charAt(aX) == 'S' && destX == aX && destY == aY + 1) {
                        counter++;
                        return counter;
                    }

                if (aX + 1 < map[0].length() && !visited[(aY) * lineLength + aX + 1])                           //RIGHT
                    if (map[aY].charAt(aX + 1) == '.' || map[aY].charAt(aX + 1) == 'B' ) {
                        next.add((aY) * lineLength + aX + 1);
                        visited[(aY) * lineLength + aX + 1] = true;
                    } else if (map[aY].charAt(aX + 1) == 'S' && destX == aX + 1 && destY == aY) {
                        counter++;
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



// Name: Henry Darnell
// ID: 010646670

import java.util.*;

public class Assignment3B {

    public static void main(String[] args) {
        Assignment3B tester = new Assignment3B();

        int[] sequence = {9, 25, 25, 9};
        System.out.println(tester.numStep(sequence));

        int[] sequence2 = {1, 1, 1, 3};
        System.out.println(tester.numStep(sequence2));

        int[] sequence3 = {3, 23, 21, 23, 42, 39, 63, 76, 13, 13, 13, 32, 12, 42, 26};
        System.out.println(tester.numStep(sequence3));

        int[] sequence4 = {7073, 755, 7328, 5694, 277, 5412, 9642, 9610, 1, 4, 1805, 1445, 901, 9750, 432, 2206, 3328, 3857, 49, 601, 650, 475, 6710, 1955, 683, 9750, 417, 1788, 47, 94, 706, 786, 318, 9610, 777, 4316, 798, 3751, 864, 3095, 1730, 1115, 357, 1472, 2750, 5639, 164, 423, 1102, 7828};
        System.out.println(tester.numStep(sequence4));

    }

    public int numStep(int[] sequence) {
        ArrayList<Integer> seq = new ArrayList<Integer>();
        for (int i = 0; i < sequence.length; i++) {
            seq.add(sequence[i]);
        }
        int a = 0;
        int b = seq.size() - 1;
        int counter = 0;

        while (a < b) {

            if (seq.get(a).equals(seq.get(b))) {
                a++;
                b--;
            }
            if (seq.get(a) < seq.get(b)) {
                seq.set(a + 1, seq.get(a + 1) + seq.get(a));
                seq.remove(a);
                b--;
                counter++;
            }
            if (seq.get(a) > seq.get(b)) {
                seq.set(b - 1, seq.get(b - 1) + seq.get(b));
                seq.remove(b);
                b--;
                counter++;
            }
        }
        return counter;
    }
}

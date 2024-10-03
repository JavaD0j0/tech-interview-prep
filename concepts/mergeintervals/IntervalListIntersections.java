package concepts.mergeintervals;

import java.util.ArrayList;

/*
    For two lists of closed intervals given as input, intervalLista and intervalListb, where each interval has its own 
    start and end time, write a function that returns the intersection of the two interval lists.

    For example, the intersection of [3,8] and [5,10] is [5,8].

    Constraints:
        1) 0 ≤ intervalLista.length, intervalListb.length ≤ 1000
        2) 0 ≤ start[i] < end[i] ≤ 10^9, where i is used to indicate intervalLista
        3) end[i] < start[i + 1]
        4) 0 ≤ start[j] < end[j] ≤ 10^9, where j is used to indicate intervalListb
        5) end[j] < start[j + 1]
 */
public class IntervalListIntersections {
    /*
     * Time Complexity: O(n + m)
     * Space Complexity: O(n)
     */
    public static int[][] intervalListIntersections(int[][] intervalListA, int[][] intervalListB) {

        int i = 0, j = 0;
        ArrayList<int[]> output = new ArrayList<>();

        while (i < intervalListA.length && j < intervalListB.length) {
            int start = Math.max(intervalListA[i][0], intervalListB[j][0]);
            int end = Math.min(intervalListA[i][1], intervalListB[j][1]);

            if (start <= end) {
                output.add(new int[] { start, end });
            }

            if (intervalListA[i][1] < intervalListB[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return output.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] intervalListA = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] intervalListB = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] output = intervalListIntersections(intervalListA, intervalListB);

        for (int[] interval : output) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

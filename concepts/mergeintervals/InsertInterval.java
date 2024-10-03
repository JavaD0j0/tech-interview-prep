package concepts.mergeintervals;

import java.util.ArrayList;

/*
    Given a sorted list of nonoverlapping intervals and a new interval, your task is to insert the new 
    interval into the correct position while ensuring that the resulting list of intervals remains sorted 
    and nonoverlapping. Each interval is a pair of nonnegative numbers, the first being the start time and 
    the second being the end time of the interval.

    Constraints:
        1) 0 ≤ existing_intervals.length ≤ 10^4
        2) existing_intervals[i].length, new_interval.length == 2
        3) 0 ≤ start time << end time ≤ 10^4
        4) The list of intervals is sorted in ascending order based on the start timestart time.
 */
public class InsertInterval {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        if (existingIntervals.length == 0) {
            return new int[][] { newInterval };
        }

        ArrayList<int[]> output = new ArrayList<>();
        for (int i = 0; i < existingIntervals.length; i++) {
            if (newInterval[1] < existingIntervals[i][0]) {
                output.add(newInterval);

                while (i < existingIntervals.length) {
                    output.add(existingIntervals[i]);
                    i++;
                }
                return output.toArray(int[][]::new);

            } else if (newInterval[0] > existingIntervals[i][1]) {
                output.add(existingIntervals[i]);

            } else {
                newInterval[0] = Math.min(newInterval[0], existingIntervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], existingIntervals[i][1]);
            }
        }

        output.add(newInterval);
        return output.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] intervals = { {1, 3}, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] result = insertInterval(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

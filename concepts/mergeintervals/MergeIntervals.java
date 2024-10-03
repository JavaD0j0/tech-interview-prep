package concepts.mergeintervals;

import java.util.LinkedList;

/*
    We are given an array of closed intervals, intervals, where each interval has a start time and an end time. 
    The input array is sorted with respect to the start times of each interval. 
    For example, intervals = [ [1,4], [3,6], [7,9] ][ [1,4], [3,6], [7,9] ] is sorted in terms of start times 1, 3, and 7.

    Your task is to merge the overlapping intervals and return a new output array consisting of only the non-overlapping intervals.

    Constraints:
        1) 1 ≤ intervals.length ≤ 10^3
        2) intervals[i].length = 2
        3) 0 ≤ start time ≤ end time ≤ 10^4
 */
public class MergeIntervals {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        
        if (intervals.length == 0) {
            return intervals;
        }

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            int[] lastAddedInterval = result.getLast();
            int currStart = currInterval[0];
            int currEnd = currInterval[1];
            int prevEnd = lastAddedInterval[1];

            if (currStart <= prevEnd) {
                lastAddedInterval[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[]{currStart, currEnd});
            }
        }

        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] intervals = { { 1, 4 }, { 3, 6 }, { 7, 9 } };
        int[][] result = mergeIntervals(intervals);
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

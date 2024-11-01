package medium.arrayandstrings;

import java.util.Arrays;
import java.util.LinkedList;

/*
    https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 0) {
            return intervals;
        }

        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            int[] prevInterval = result.getLast();
            int currStart = currInterval[0];
            int currEnd = currInterval[1];
            int prevEnd = prevInterval[1];

            if (currStart <= prevEnd) {
                prevInterval[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[]{currStart, currEnd});
            }
        }

        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] intervals = {{1, 4}, {3, 6}, {7, 9}};
        int[][] result = new MergeIntervals().merge(intervals);
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

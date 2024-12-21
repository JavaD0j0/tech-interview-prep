/*
 *  https://leetcode.com/problems/merge-intervals/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[][] mergeBruteForce(int[][] intervals) {
        
        boolean merged = true;

        // Loop until no further merging is possible
        while (merged) {
            merged = false;
            List<int[]> temp = new ArrayList<>();
            boolean[] used = new boolean[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                if (used[i]) continue;

                int[] a = intervals[i];
                boolean hasMerged = false;

                for (int j = i + 1; j < intervals.length; j++) {
                    if (used[j]) continue;

                    int[] b = intervals[j];

                    // Check for overlap
                    if (a[1] >= b[0] && a[0] <= b[1]) {
                        used[j] = true;
                        a = new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
                        hasMerged = true;
                    }
                }

                temp.add(a);
                if (hasMerged) merged = true;
            }

            intervals = temp.toArray(int[][]::new);
        }

        return intervals;
    }

    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public int[][] mergeOptimized(int[][] intervals) {
        
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
}

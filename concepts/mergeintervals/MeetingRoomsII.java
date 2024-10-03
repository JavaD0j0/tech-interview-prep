package concepts.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    We are given an input array of meeting time intervals, intervals, where each interval has a start time and an end time. 
    Your task is to find the minimum number of meeting rooms required to hold these meetings.

    An important thing to note here is that the specified end time for each meeting is exclusive.

    Constraints
        1) 1 <= intervals.length <= 10^3
        2) 0 ≤ start(i)​ < end(i)​ ≤ 10^6
 */
public class MeetingRoomsII {
    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public static int findSets(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Use a min-heap to keep track of end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            // If the room due to free up the earliest is free, remove it from the heap
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll();
            }

            // Add the current meetings end time to the heap
            minHeap.offer(interval[1]);
        }

        // The size of the heap is the number of rooms required
        return minHeap.size();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] intervals = { { 1, 3 }, { 5, 7 }, { 5, 9 }, { 8, 10 } };
        System.out.println(findSets(intervals));
    }
}

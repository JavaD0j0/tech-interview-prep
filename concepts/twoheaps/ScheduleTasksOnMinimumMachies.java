package concepts.twoheaps;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
    We are given an input array, tasks, which contains the start and end times of n tasks. Your task is to find the 
    minimum number of machines required to complete these n tasks.

    Constraints:
        1) n == tasks.length
        2) 1 <= tasks.length <= 10^3
        3) 0 ≤ tasks[i].start < tasks[i].end ≤ 10^4
 */
public class ScheduleTasksOnMinimumMachies {
    /*
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int tasks(List<List<Integer>> tasksList) {
        
        // Sort the tasks by start time
        tasksList.sort((a, b) -> a.get(0) - b.get(0));

        // Use a min-heap to track the end times of the tasks
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // Loop through each task
        for (List<Integer> task : tasksList) {
            int start = task.get(0);
            int end = task.get(1);
            
            // If the machine that finishes the earliest is free (end time <= current task's start time)
            if (!heap.isEmpty() && heap.peek() <= start) {
                heap.poll();  // Remove the machine that's now free
            }
            // Assign a machine to the current task (push its end time to the heap)
            heap.offer(end);
        }
        
        // The size of the heap is the minimum number of machines required
        return heap.size();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        List<List<Integer>> tasksList = Arrays.asList(
            Arrays.asList(1, 1),
            Arrays.asList(5, 5),
            Arrays.asList(8, 8),
            Arrays.asList(4, 4),
            Arrays.asList(6, 6),
            Arrays.asList(10, 10),
            Arrays.asList(7, 7)
        );
        System.out.println(tasks(tasksList));

        List<List<Integer>> tasksList2 = Arrays.asList(
            Arrays.asList(12, 13),
            Arrays.asList(13, 15),
            Arrays.asList(17, 20),
            Arrays.asList(13, 14),
            Arrays.asList(19, 21),
            Arrays.asList(18, 20)
        );
        System.out.println(tasks(tasksList2));
    }
}

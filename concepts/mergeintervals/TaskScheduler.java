package concepts.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a character array tasks, where each character represents a unique task and a positive integer n that 
    represents the cooling period between any two identical tasks, find the minimum number of time units the CPU 
    will need to complete all the given tasks. Each task requires one unit to perform, and the CPU must wait 
    for at least n units of time before it can repeat the same task. During the cooling period, the CPU 
    can perform other tasks or remain idle.

    Constraints:
        1) 1 ≤ tasks.length ≤ 1000
        2) 0 ≤ n ≤ 100
        3) tasks consists of uppercase English letters
 */
public class TaskScheduler {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since we will be storing at most 26 characters in a hashmap
     */
    public static int leastTime(char[] tasks, int n) {
        
        HashMap<Character, Integer> frequencies = new HashMap<>();

        // Create hashmap with frequency of tasks
        for (char t : tasks) {
            frequencies.put(t, frequencies.getOrDefault(t, 0) + 1);
        }
        
        // Sort the frequencies in descending order
        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        // Compute the maximum idle time
        int idleTime = (maxFreq - 1) * n;

        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }

        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C'};
        int n = 1;
        System.out.println(leastTime(tasks, n));
    }
}

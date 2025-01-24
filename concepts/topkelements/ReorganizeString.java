package concepts.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    Given a string, str, rearrange it so that any two adjacent characters are not the same. If such a reorganization of the characters is possible, output any possible valid arrangement. Otherwise, return an empty string.

    Constraints:
        1) 1 ≤ str.length ≤ 500
        2) Input string consists of lowercase English letters.
 */
public class ReorganizeString {
    /*
     * Time complexity: O(n)
     * Space complexity: O(1) since the maximum size of the heap will be 26
     */
    public static String reorganizeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(reorganizeString("aappp")); // papap
        System.out.println(reorganizeString("aa")); // ""
        System.out.println(reorganizeString("aaab")); // ""
        System.out.println(reorganizeString("aaabbb")); // ababab
    }
}

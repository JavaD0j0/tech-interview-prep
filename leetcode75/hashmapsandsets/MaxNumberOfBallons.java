/*
 *   https://leetcode.com/problems/maximum-number-of-balloons/description/
 */
public class MaxNumberOfBallons {
    /*
    * Time Complexity: O(n)
    * Space Complexity: O(1), as the frequency array is of fixed size (26 characters)
    */
    public int maxNumberOfBalloonsOptimized(String text) {
        Set<Character> set = new HashSet<>(Arrays.asList('b', 'a', 'l', 'l', 'o', 'n'));
        Map<Character, Integer> map = new HashMap<>();

        if (text.isEmpty()) {
            return 0;
        }

        for (char c : text.toCharArray()) {
            if (set.contains(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        if (!map.containsKey('b') || !map.containsKey('a') || !map.containsKey('l') ||
            !map.containsKey('o') || !map.containsKey('n')) {
            return 0;
        }

        // Count the number of 'b', 'a', 'l', 'o', and 'n' characters
        return Math.min(map.getOrDefault('b', 0), Math.min(map.getOrDefault('a', 0), 
                Math.min(map.getOrDefault('l', 0), Math.min(map.getOrDefault('o', 0), map.getOrDefault('n', 0)))));
    }
}

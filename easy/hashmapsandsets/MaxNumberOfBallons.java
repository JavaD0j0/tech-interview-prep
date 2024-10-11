package easy.hashmapsandsets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
    https://leetcode.com/problems/maximum-number-of-balloons/description/
 */
public class MaxNumberOfBallons {

    public int maxNumberOfBalloons(String text) {
        /*
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         */
        HashSet<Character> set = new HashSet<>(Arrays.asList('b', 'a', 'l', 'l', 'o', 'n'));
        HashMap<Character, Integer> map = new HashMap<>();

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

        return Math.min(map.getOrDefault('b', 0), Math.min(map.getOrDefault('a', 0), 
                Math.min(map.getOrDefault('l', 0), Math.min(map.getOrDefault('o', 0), map.getOrDefault('n', 0)))));
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        MaxNumberOfBallons m = new MaxNumberOfBallons();
        System.out.println(m.maxNumberOfBalloons("loonbalxballpoon"));
    }
}

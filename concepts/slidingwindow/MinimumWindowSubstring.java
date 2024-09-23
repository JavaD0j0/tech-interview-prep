package concepts.slidingwindow;

import java.util.*;
/*
    Given two strings, s and t, find the minimum window substring in s, which has the following properties:

        1. It is the shortest substring of s that includes all of the characters present in t.
        2. It must contain at least the same frequency of each character as in t.
        3. The order of the characters does not matter here.

    Note: If there are multiple valid minimum window substrings, return any one of them.

    Constraints:
        1) Strings s and t consist of uppercase and lowercase English characters.
        2) 1 ≤ s.length, t.length ≤10^3
 */
public class MinimumWindowSubstring {
    
    /*
     * Time Complexity: O(n + m), where n is the length of the string s and m is the length of the string t
     * Space Complexity: O(1), since we will be storing at most 52 characters (uppercase and lowercase English letters) in a hashmap
     */
    public static String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }

        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            reqCount.put(c, 1 + reqCount.getOrDefault(c, 0));
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            window.put(c, 0);
        }

        int current = 0;
        int required = reqCount.size();

        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (t.indexOf(c) != -1) {
                window.put(c, 1 + window.getOrDefault(c, 0));
            }

            if (reqCount.containsKey(c) && window.get(c).equals(reqCount.get(c))) {
                current += 1;
            }

            while (current == required) {
                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = (right - left + 1);
                }

                char leftChar = s.charAt(left);
                if (t.indexOf(leftChar) != -1) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                if (reqCount.containsKey(leftChar) && window.get(leftChar) < reqCount.get(leftChar)) {
                    current -= 1;
                }
                left += 1;
            }
        }

        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}

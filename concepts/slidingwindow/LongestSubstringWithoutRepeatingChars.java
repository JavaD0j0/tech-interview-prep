package concepts.slidingwindow;

import java.util.*;
/*
    Given a string, str, return the length of the longest substring without repeating characters.

    Constraints:
        1) 1 ≤ str.length ≤ 10^5
        2) str consists of English letters, digits, and spaces.
 */
public class LongestSubstringWithoutRepeatingChars {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since there's only a limited number of unique characters that could appear in the input string
     */
    public static int findLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);
            if (map.containsKey(currentChar)) {
                // if the character already exists in the map, move the start pointer to the right
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String str = "abcabcbb";
        System.out.println(findLongestSubstring(str));

        str = "bbbbb";
        System.out.println(findLongestSubstring(str));
    }
}

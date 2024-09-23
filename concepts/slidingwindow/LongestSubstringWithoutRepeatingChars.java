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
        if (str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int windowStart = 0, longest = 0, windowLength = 0, i = 0;

        HashMap<Character, Integer> lastSeenAt = new HashMap<>();

        for (i = 0; i < n; i++) {
            if (!lastSeenAt.containsKey(str.charAt(i))) {
                lastSeenAt.put(str.charAt(i), i);
            } else { 
                if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
                    windowLength = i - windowStart;
                    if (longest < windowLength) {
                        longest = windowLength;
                    }
                    windowStart = lastSeenAt.get(str.charAt(i)) + 1;
                }
                lastSeenAt.replace(str.charAt(i), i);
            }
        }

        if (longest < i - windowStart) {
            longest = i - windowStart;
        }

        return longest;
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

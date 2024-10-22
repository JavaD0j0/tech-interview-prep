package concepts.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string s and an integer k, find the length of the longest substring in s, where all characters are identical, 
    after replacing, at most, k characters with any other lowercase English character.

    Constraints:
        1) 1 ≤ s.length ≤ 10^3
        2) s consists of only lowercase English characters
        3) 0 ≤ k ≤ s.length
 */
public class LongestRepeatingCharacterReplacement {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since we will be storing at most 26 characters in a hashmap
     */
    public static int longestRepeatingCharacterReplacement(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int lengthOfMaxSubstring = 0;
        int left = 0;
        int mostFreqChar = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); ++right) {
            char currentChar = s.charAt(right);
            
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, map.get(currentChar));

            // If length of current window - most frequent character > k, we need to shrink the window
            int length = right - left + 1;
            if (length - mostFreqChar > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, length);
        }

        return lengthOfMaxSubstring;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String s = "bbbbbbbbb";
        int k = 4;
        System.out.println(longestRepeatingCharacterReplacement(s, k));

        s = "aabccbb";
        k = 2;
        System.out.println(longestRepeatingCharacterReplacement(s, k));
    }
}
package medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingChars {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                // Update left pointer to the next position after the rightmost repeating character 
                left = Math.max(map.get(s.charAt(right)), left);
            }

            map.put(s.charAt(right), right + 1);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}

/*
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since we will be storing at most 26 characters in a hashmap
     */
    public int characterReplacement(String s, int k) {
        
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
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(max, map.get(s.charAt(right)));

            while (right - left + 1 - max > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
        }

        return right - left;
    }
}

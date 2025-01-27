/*
 *  https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingChars {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;

        // Iterate over all possible substrings
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) {
                    break; // Stop if a character repeats
                }
                seen.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since the map can only contain 26 characters
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Move the left pointer to avoid duplicates
            if (lastSeen.containsKey(currentChar)) {
                left = Math.max(left, lastSeen.get(currentChar) + 1);
            }

            // Update the last seen index of the character
            lastSeen.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/*
 *  https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n), for storing the character arrays
     */
    public boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort the arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted arrays
        return Arrays.equals(sArray, tArray);
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since the frequency map will have at most 26 characters
     */
    public boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in the first string
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Check if the second string has the same frequency of characters
        for (char c : t.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}

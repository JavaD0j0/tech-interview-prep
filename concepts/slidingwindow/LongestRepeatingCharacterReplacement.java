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

        int lengthOfMaxSubstring = 0;
        int start = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        for (int end = 0; end < s.length(); ++end) {
            char currentChar = s.charAt(end);
            
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);
            
            mostFreqChar = Math.max(mostFreqChar, charFreq.get(currentChar));

            if (end - start + 1 - mostFreqChar > k) {
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start += 1;
            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
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
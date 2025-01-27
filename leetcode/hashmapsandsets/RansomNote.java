/*
 *   https://leetcode.com/problems/ransom-note/description/
 */
public class RansomNote {
    /*
     * Time Complexity: O(n * m), where n is the length of ransomNote and m is the length of magazine
     * Space Complexity: O(m), for the StringBuilder
     */
    public boolean canConstructBruteForce(String ransomNote, String magazine) {
        StringBuilder magazineBuilder = new StringBuilder(magazine);

        for (char c : ransomNote.toCharArray()) {
            int index = magazineBuilder.indexOf(String.valueOf(c));
            if (index == -1) {
                return false;
            }
            magazineBuilder.deleteCharAt(index); // Remove used character
        }

        return true;
    }

    /*
     * Time Complexity: O(n + m), where n is the length of ransomNote and m is the length of magazine
     * Space Complexity: O(1), since we will be storing at most lowercase English letters
     */
    public boolean canConstructOptimized(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        // Store the frequency of each character in magazine
        for (char mag : magazine.toCharArray()) {
            map.put(mag, map.getOrDefault(mag, 0) + 1);
        }

        // Check if ransomNote can be constructed
        for (char note : ransomNote.toCharArray()) {
            if (map.getOrDefault(note, 0) > 0) {
                map.put(note, map.get(note) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}

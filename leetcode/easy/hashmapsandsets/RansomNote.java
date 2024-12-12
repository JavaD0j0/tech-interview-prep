/*
 *   https://leetcode.com/problems/ransom-note/description/
 */
public class RansomNote {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), since we will be storing at most lowercase English letters
     */
        public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        for (char mag : magazine.toCharArray()) {
            map.put(mag, map.getOrDefault(mag, 0) + 1);
        }

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

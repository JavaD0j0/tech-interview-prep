package easy.hashmapsandsets;

import java.util.HashMap;

/*
    https://leetcode.com/problems/ransom-note/description/
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

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String ransomNote = "a";
        String magazine = "b";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "ab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
    }
}

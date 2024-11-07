package easy.hashmapsandsets;

import java.util.HashMap;

/*
    https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String s = "anagram";
        String t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    
        s = "rat";
        t = "car";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }
}

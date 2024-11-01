package easy.arrayandstrings;

/*
 * https://leetcode.com/problems/merge-strings-alternately/description/
 */
public class MergeStringsAlternately {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < word1.length() && i < word2.length()) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }
        
        result.append(word1.substring(i));
        result.append(word2.substring(i));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String word1 = "abcd";
        String word2 = "pq";
        String result = new MergeStringsAlternately().mergeAlternately(word1, word2);
        System.out.println(result);
    }
}

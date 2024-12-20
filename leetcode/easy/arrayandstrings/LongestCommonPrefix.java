/*
 *   https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        int minLength = Integer.MAX_VALUE;

        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            for (String str : strs) {
                if (str.charAt(i) != strs[0].charAt(i)) {
                    return output.toString();
                }
            }
            output.append(strs[0].charAt(i));
        }

        return output.toString();
    }
}

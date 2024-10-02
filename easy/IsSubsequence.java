package easy;

/*
 * https://leetcode.com/problems/is-subsequence/description/
 */
public class IsSubsequence {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < sSize && tPointer < tSize) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }

        return sPointer == sSize;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));

        System.out.println();
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }

}

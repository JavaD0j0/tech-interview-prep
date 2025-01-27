/*
 *   https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void reverseStringBruteForce(char[] s) {
        char[] reversed = new char[s.length];

        for (int i = 0; i < s.length; i++) {
            reversed[i] = s[s.length - 1 - i];
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void reverseStringOptimized(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

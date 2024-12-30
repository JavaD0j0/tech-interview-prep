/*
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean isPalindromeBruteForce(String s) {
        // Filter and normalize the string
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // Check if filtered string is equal to its reverse
        String original = filtered.toString();
        String reversed = filtered.reverse().toString();
        return original.equals(reversed);
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindromeOptimized(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            // Skip non-alphanumeric characters
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}

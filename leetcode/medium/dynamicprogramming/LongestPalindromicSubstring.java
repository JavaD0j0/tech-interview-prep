/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    /*
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public String longestPalindromeBruteForce(String s) {
        int n = s.length();
        String longest = "";
        
        // Check all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        
        return longest;
    }
    
    // Helper function to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public String longestPalindromeOptimized(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindromes
            int maxLen = Math.max(len1, len2);
            
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2; // Left end of the palindrome
                end = i + maxLen / 2;         // Right end of the palindrome
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand around a center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
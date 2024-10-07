package concepts.twopointers;

/*
    Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    Constraints:
        1) 1 ≤ string.length ≤ 10^3
        2) The string only consists of English letters.
 */
public class IsPalindromeII {
    /*
    * Time Complexity: O(n), where n is the length of the string.
    * Space Complexity: O(1)
    */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindromeHelper(s, left + 1, right) || isPalindromeHelper(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindromeHelper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        String test1 = "MADATM";
        System.err.println(isPalindrome(test1));

        String test2 = "abcdeca";
        System.err.println(isPalindrome(test2));
    }
}

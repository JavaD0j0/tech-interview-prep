package concepts.twopointers;

/*
    Write a function that takes a string, s, as an input and determines whether or not it is a palindrome.

    Note: A palindrome is a word, phrase, or sequence of characters that reads the same backward as forward.

    Constraints:
        1) 1 ≤ s.length ≤ 2×10^5
        2) The string s will not contain any white space and will only consist of ASCII characters(digits and letters).
 */
public class IsPalindrome {
    /*
    * Time Complexity: O(n), where n is the length of the string.
    * Space Complexity: O(1)
    */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
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

        String test1 = "MADAM";
        String test2 = "racecar";
        String test3 = "hello";
        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));
    }
}

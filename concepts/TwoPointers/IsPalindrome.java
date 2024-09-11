package concepts.twopointers;

/*
 * Time Complexity: O(n), where n is the length of the string. However, the algorithm
 * will only run (n/2) times, since two pointers are traversing toward each other.
 * 
 * Space Complexity: O(1)
 */
public class IsPalindrome {
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

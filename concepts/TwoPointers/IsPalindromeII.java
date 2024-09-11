package concepts.twopointers;

public class IsPalindromeII {
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

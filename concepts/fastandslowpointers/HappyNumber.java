package concepts.fastandslowpointers;

/*
    Write an algorithm to determine if a number n is a happy number.

    We use the following process to check if a given number is a happy number:

        Starting with the given number n, replace the number with the sum of the squares of its digits.
        Repeat the process until:
            The number equals 1, which will depict that the given number n is a happy number.
            The number enters a cycle, which will depict that the given number nn is not a happy number.

    Return TRUE if nn is a happy number, and FALSE if not.

    Constraints
        1) 1 ≤ n ≤ 2^31 − 1 
 */
public class HappyNumber {
    /*
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = findSquareSum(n);

        while (fast != 1 && slow != fast) {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        }

        return fast == 1;
    }

    private static int findSquareSum(int n) {
        int squareSum = 0;
        while (n > 0) {
            int digit = n % 10;
            squareSum += digit * digit;
            n /= 10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int n = 19;
        System.out.println(isHappy(n));
    }
}

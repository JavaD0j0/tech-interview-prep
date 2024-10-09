package easy.arrayandstrings;

/*
 * https://leetcode.com/problems/find-closest-number-to-zero/description/
 */
public class FindClosestNumberToZero {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                result = nums[i];
            } else if (Math.abs(nums[i]) == min && result < nums[i]) {
                result = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { -4, -2, 1, 4, 8 };
        System.out.println(new FindClosestNumberToZero().findClosestNumber(nums));

        nums = new int[] { -1000, -1000 };
        System.out.println(new FindClosestNumberToZero().findClosestNumber(nums));

        nums = new int[] { 2, 1, 1, -1, 100000 };
        System.out.println(new FindClosestNumberToZero().findClosestNumber(nums));
    }
}

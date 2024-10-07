package concepts.slidingwindow;

/*
    Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a contiguous subarray 
    whose sum is greater than or equal to the target. If no such subarray is found, return 0.

    Constraints:
        1) 1 ≤ target ≤ 10^4
        2) 1 ≤ nums.length ≤ 10^3
        3) 1 ≤ nums[i] ≤ 10^3
 */
public class MinimumSizeSubarraySum {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int windowSize = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            // if sum is greater than target, shrink the window from the left side of the array
            // until the sum is less than or equal to target and update the minimum window size
            while (sum >= target) {
                int currSubArrSize = (end + 1) - start;
                windowSize = Math.min(windowSize, currSubArrSize);
                sum -= nums[start];
                start++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));

        nums = new int[]{5, 4, 9, 8, 11, 3, 7, 12, 15, 44};
        target = 15;
        System.out.println(minSubArrayLen(target, nums));
    }
}

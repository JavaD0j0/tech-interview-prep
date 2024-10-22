package easy.slidingwindow;

/*
    https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public double findMaxAverage(int[] nums, int k) {
        double curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }

        double maxAvg = curSum / k;

        for (int i = k; i < nums.length; i++) {
            curSum += nums[i];
            curSum -= nums[i - k];

            double avg = curSum / k;
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(nums, k));
    }
}

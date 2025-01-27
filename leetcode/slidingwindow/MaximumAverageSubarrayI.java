/*
 *  https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {
    /*
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    public double findMaxAverageBruteForce(int[] nums, int k) {
        int n = nums.length;
        double maxAverage = Double.NEGATIVE_INFINITY;

        // Iterate over all possible subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public double findMaxAverageOptimized(int[] nums, int k) {
        int n = nums.length;
        int windowSum = 0;

        // Compute the initial sum of the first k elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k]; // Add new element, remove the old one
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}

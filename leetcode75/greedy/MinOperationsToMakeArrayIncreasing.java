/*
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/description/
 */
public class MinOperationsToMakeArrayIncreasing {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int minOperationsBruteForce(int[] nums) {
        int operations = 0;

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i]++;
                operations++;
            }
        }
        
        return operations;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minOperationsOptimized(int[] nums) {
        int operations = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Calculate the difference needed to make nums[i] strictly greater
                int diff = (nums[i - 1] + 1) - nums[i];
                operations += diff;
                // Update nums[i] to the new value
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        return operations;
    }
}

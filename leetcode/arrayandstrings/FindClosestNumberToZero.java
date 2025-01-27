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
            // If the absolute value is less than the current min, update the min and result
            if (Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                result = nums[i];
                
            } else if (Math.abs(nums[i]) == min && result < nums[i]) { // If the absolute value is the same, choose the larger number
                result = nums[i];
            }
        }

        return result;
    }
}

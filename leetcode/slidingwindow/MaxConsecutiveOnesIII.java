/*
 *  https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaxConsecutiveOnesIII {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int longestOnesBruteForce(int[] nums, int k) {
        int maxLength = 0;

        // Iterate over all starting points
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }
                if (zeroCount > k) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestOnesOptimized(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            // Expand the window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window if zero count exceeds k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}

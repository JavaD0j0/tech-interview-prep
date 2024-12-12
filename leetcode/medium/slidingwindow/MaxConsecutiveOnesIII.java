/*
 *  https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class MaxConsecutiveOnesIII {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int subarraySumBruteForce(int[] nums, int k) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    total++;
                }
            }
        }
        return total;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int subarraySumOptimized(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: 0 occurs once

        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);      // If sum - k exists in map, then that means that a subarray exists that sums to k
            map.put(sum, map.getOrDefault(sum, 0) + 1); // Update map to include current sum
        }

        return count;
    }
}

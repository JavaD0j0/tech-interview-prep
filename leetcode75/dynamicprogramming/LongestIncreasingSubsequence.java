/*
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int lengthOfLISBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Initialize all subsequence lengths to 1

        int maxLength = 1;  // Tracks the overall maximum LIS length
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

    /*
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int lengthOfLISOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
                
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            int left = 0;
            int right = tails.size();
            
            // Binary search for the correct position of num in tails
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // If num is larger than all elements in tails, it extends the subsequence
            if (left == tails.size()) {
                tails.add(num);
            } else {
                // Otherwise, replace the element at index `left` with num
                tails.set(left, num);
            }
        }
        
        return tails.size();
    }
}

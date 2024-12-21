/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class IncreasingTripletSubsequence {
    /*
     * Time Complexity: O(n^3)
     * Space Complexity: O(1) 
     */
    public boolean increasingTripletBruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean increasingTripletOptimized(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
    
}

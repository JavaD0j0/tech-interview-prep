/*
 *  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumII {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSumBruteForce(int[] numbers, int target) {
        int n = numbers.length;

        // Check every pair of numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] twoSumOptimized(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
}

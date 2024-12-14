/*
 *  https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1), excluding the result array
     */
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
    
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
    
        return result;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1), excluding the result array
     */
    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int product = 1;

        // Compute the product of the left side
        for (int i = 0; i < n; i++) {
            result[i] = product;
            product *= nums[i];
        }

        // Compute the product of the right side
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}

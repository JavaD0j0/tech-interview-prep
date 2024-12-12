/*
 *  https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;

        // Compute the product of the left side
        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        // Compute the product of the right side
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}

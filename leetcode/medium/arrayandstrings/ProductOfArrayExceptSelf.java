package medium.arrayandstrings;

/*
    https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = obj.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

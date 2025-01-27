/*
 *   https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SquaresOfSortedArray {
    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public static int[] sortedSquaresBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }

        Arrays.sort(result);
        return result;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] sortedSquaresOptimized(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int curr = right;

        int[] result = new int[nums.length];
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[curr] = leftSquare;
                left++;
            } else {
                result[curr] = rightSquare;
                right--;
            }
            curr--;
        }

        return result;
    }
}

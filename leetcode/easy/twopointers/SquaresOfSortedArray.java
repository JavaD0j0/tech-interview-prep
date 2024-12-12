/*
 *   https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class SquaresOfSortedArray {

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] sortedSquares(int[] nums) {
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

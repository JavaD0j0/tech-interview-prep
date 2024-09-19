package easy;

/**
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:
        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].

    Constraints:
        1) 1 <= nums.length <= 104
        2) -104 <= nums[i] <= 104
        3) nums is sorted in non-decreasing order.

    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
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

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

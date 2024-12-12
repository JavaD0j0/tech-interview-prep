/*
 *  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumII {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;

            } else if(numbers[left] + numbers[right] < target) {
                left++;

            } else {
                break;
            }
        }
        
        int[] result = new int[2];
        result[0] = left + 1;
        result[1] = right + 1;
        return result;
    }
}

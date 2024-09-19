package medium;

/*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up 
    to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    You may not use the same element twice.

    Your solution must use only constant extra space.

    Example 1:
        Input: numbers = [2,3,4], target = 6
        Output: [1,3]
        Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Constraints:
        1) 2 <= numbers.length <= 3 * 104
        2) -1000 <= numbers[i] <= 1000
        3) numbers is sorted in non-decreasing order.
        4) -1000 <= target <= 1000
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

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] numbers = { 2, 3, 4 };
        int target = 6;
        int[] result = twoSum(numbers, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

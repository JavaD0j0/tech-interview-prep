package concepts.twopointers;

import java.util.*;

/*
 * Time Complexity: O(n^2)
 * Space Complexity: O(log n)
 */
public class SumOfThreeValues {
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == target) {
                    return true;
                } else if (nums[i] + nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 15;
        System.out.println(findSumOfThree(nums, target));

        int[] nums2 = { 4, 1, 2, 3, 6 };
        int target2 = 9;
        System.out.println(findSumOfThree(nums2, target2));

        int[] nums3 = { 1, 0, -1 };
        int target3 = 1;
        System.out.println(findSumOfThree(nums3, target3));
    }
}

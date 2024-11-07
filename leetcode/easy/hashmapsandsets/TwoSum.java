package easy.hashmapsandsets;

import java.util.HashMap;

/*
    https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        /*
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = new TwoSum().twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }
}

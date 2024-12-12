/*
 *  https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int curr = 0; curr < nums.length - 2; curr++) {

            // Avoid duplicate triplets
            if (curr > 0 && nums[curr] == nums[curr - 1]){
                continue;
            }

            int left = curr + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[curr] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[curr], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

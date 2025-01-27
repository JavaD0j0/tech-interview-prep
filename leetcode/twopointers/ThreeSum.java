/*
 *  https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
    /*
     * Time Complexity: O(n^3)
     * Space Complexity: O(k), where k is the number of unique triplets
     */
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        HashSet<List<Integer>> uniqueTriplets = new HashSet<>();
        int n = nums.length;

        // Check every combination of three numbers
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(Integer::compareTo); // Ensure triplet order
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(uniqueTriplets);
    }

    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(k), where k is the number of unique triplets
     */
    public static List<List<Integer>> threeSumOptimized(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int curr = 0; curr < nums.length - 2; curr++) {
            // Avoid duplicate triplets for the first element
            if (curr > 0 && nums[curr] == nums[curr - 1]){
                continue;
            }

            int left = curr + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[curr] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[curr], nums[left], nums[right]));

                    // Avoid duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }

        return result;
    }
}

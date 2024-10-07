package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/summary-ranges/description/
 */
public class SummaryRanges {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();

        int end = 0;
        while (end < nums.length) {
            int start = nums[end];

            while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
                end++;
            }

            if (start == nums[end]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[end]);
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        List<String> result = summaryRanges.summaryRanges(nums);
        for (String str : result) {
            System.out.println(str);
        }
    }
}

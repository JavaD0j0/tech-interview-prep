/*
    https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int a = w * h;
            maxArea = Math.max(maxArea, a);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

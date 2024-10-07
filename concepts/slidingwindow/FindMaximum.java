package concepts.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.

    Constraints:
        1) 1 ≤ nums.length ≤ 10^3
        2) 104 ≤ nums[i] ≤ 10^4
        3) 1 ≤ w ≤ nums.length
 */
public class FindMaximum {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(w), where w is the window size
     */
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
		if (nums.length == 1) {
			return nums;
		}

		int[] output = new int[nums.length - w + 1];
		Deque<Integer> currentWindow = new ArrayDeque<>();

		for (int i = 0; i < w; i++) {
        	currentWindow = cleanUp(i, currentWindow, nums);
			currentWindow.add(i);
		}

		output[0] = nums[currentWindow.getFirst()];

		for (int i = w; i < nums.length; i++) {
			cleanUp(i, currentWindow, nums);
			if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
				currentWindow.removeFirst();
			}
			currentWindow.add(i);
			output[i - w + 1] = nums[currentWindow.getFirst()];
		}

		return output;
    }

    // function to clean up the window
	private static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
		while (!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.getLast()]) {
			currentWindow.removeLast();
		}
		return currentWindow;
	}

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int w = 3;
        int[] result = findMaxSlidingWindow(nums, w);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

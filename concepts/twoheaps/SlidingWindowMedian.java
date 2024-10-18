package concepts.twoheaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given an integer array, nums, and an integer, k, there is a sliding window of size k, which is moving from the very left 
    to the very right of the array. We can only see the k numbers in the window. Each time the sliding window moves right by one position.

    Given this scenario, return the median of the each window. Answers within 10−510−5 of the actual value will be accepted.

    Constraints:
        1) 1 ≤ k ≤ nums.length ≤ 10^3
        2)−2^31 ≤ nums[i] ≤ 2^31 − 1
 */
public class SlidingWindowMedian {
    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {

        List<Double> medians = new ArrayList<>();
        HashMap<Integer, Integer> outgoingNum = new HashMap<>(); // Keep track of number that need to be removed from the heaps
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        // Initialize the max heap
        for (int i = 0; i < k; i++) {
            smallList.offer(nums[i]);
        }

        // Transfer the top 50% elements from the max heap to the min heap
        for (int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        int balance = 0; // variable to keep the heap balanced
        int i = k;
        while (true) {
            // if k is odd, the median is the top element of the max heap (smallList)
            if ((k & 1) == 1) {
                medians.add((double) (smallList.peek()));
            } else {
                medians.add((double) ((long)smallList.peek() + (long)largeList.peek()) * 0.5);
            }

            if (i >= nums.length)
                break;

            int outNum = nums[i - k];
            int inNum = nums[i];
            i++;

            // Outgoing number is from the max heap
            if (outNum <= smallList.peek()) {
                balance -= 1;
            } else {
                balance += 1;
            }

            if (outgoingNum.containsKey(outNum)) {
                outgoingNum.put(outNum, outgoingNum.get(outNum) + 1);
            } else {
                outgoingNum.put(outNum, 1);
            }

            if (!smallList.isEmpty() && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            } else {
                balance -= 1;
                largeList.offer(inNum);
            }

            if (balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0) {
                largeList.offer(smallList.poll());
            }
            
            balance = 0;

            while (!smallList.isEmpty() && outgoingNum.containsKey(smallList.peek()) && outgoingNum.get(smallList.peek()) > 0) {
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.poll()) - 1);
            }

            while (!largeList.isEmpty() && outgoingNum.containsKey(largeList.peek()) && outgoingNum.get(largeList.peek()) > 0) {
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.poll()) - 1);
            }
        }

        double[] arr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] nums = { 3, 1, 2, -1, 0, 5, 8 };
        int k = 4;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }
}

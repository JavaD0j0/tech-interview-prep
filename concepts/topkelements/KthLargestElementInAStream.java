package concepts.topkelements;

import java.util.PriorityQueue;

/*
    Given an infinite stream of integers (sorted or unsorted), nums, design a class to find the kthkth largest element in a stream.

    > Note: It is the kthkth largest element in the sorted order, not the kthkth distinct element.

    The class should have the following functions, inputs, and return values:

        - Init(nums, k): It takes an array of integers nums and an integer k and initializes the class object.
        - Add(value): It takes one integer value, appends it to the stream, and returns the element representing the kthkth largest element in the stream.

    Constraints:
        1) 1 ≤ k ≤ 10^3
        2) 0 ≤ nums.length ≤ 10^3
        3) −10^3 ≤ nums[i] ≤ 10^3
        4) −10^3 ≤ value ≤ 10^3
        5) At most, 10^3 calls will be made to add.
        6) It is guaranteed that there will be at least kk elements in the array when you search for the kth element.
 */
public class KthLargestElementInAStream {
    /*
     * Time Complexity: O(nlog(k)) for constructor
     * Time Complexity: O(log(k)) for add() method
     * Space Complexity: O(k)
     */
    public PriorityQueue<Integer> minHeap;
    public int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);

        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        
        KthLargestElementInAStream kthLargestElementInAStream = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargestElementInAStream.add(3)); // 4
        System.out.println(kthLargestElementInAStream.add(5)); // 5
        System.out.println(kthLargestElementInAStream.add(10)); // 5
        System.out.println(kthLargestElementInAStream.add(9)); // 8
        System.out.println(kthLargestElementInAStream.add(4)); // 8
    }
}

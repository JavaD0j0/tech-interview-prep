package concepts.twoheaps;

import java.util.PriorityQueue;

/*
    Create a data structure that can store a list of integers that can change in size over time and find the median from this 
    dynamically growing list in constant time, O(1).

    Implement a class, MedianOfStream, which should support the following operations:
        - Constructor(): This initializes the object of this class, which in turn creates the max and the min heap.
        - Insert Num(num): This adds an integer, num, to the data structure.
        - Find Median(): This finds the median of all elements seen so far. If there are an even number of elements, return the average of the two middle values.

    Constraints:
        1) −10^5 ≤ num ≤ 10^5, where num is an integer received from the data stream.
        2) There will be at least one element in the data structure before the median is computed.
        3) At most, 500 calls will be made to the function that calculates the median.
 */
public class FindMedianFromDataStream {
    /*
     * Time Complexity: O(log(n))
     * Space Complexity: O(n)
     */
    PriorityQueue<Integer> maxHeapForSmallNum; //containing first half of numbers
    PriorityQueue<Integer> minHeapForLargeNum; //containing second half of numbers

    public FindMedianFromDataStream() {
        maxHeapForSmallNum = new PriorityQueue<>((a, b) -> b - a);
        minHeapForLargeNum = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        // Add the number to the appropriate heap
        if (maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek() >= num) {
          maxHeapForSmallNum.add(num);
        } else {
          minHeapForLargeNum.add(num);
        }
    
        // If the size of the two heaps are different, swap them to ensure that the heaps are balanced
        if (maxHeapForSmallNum.size() > minHeapForLargeNum.size() + 1) {
          minHeapForLargeNum.add(maxHeapForSmallNum.poll());
        } else if (maxHeapForSmallNum.size() < minHeapForLargeNum.size()) {
          maxHeapForSmallNum.add(minHeapForLargeNum.poll());
        }
    }
    
      public double findMedian() {
        // If the heaps are balanced, return the average of the top elements of the heaps
        // If the heaps are not balanced, return the top element of the heap with the larger size
        if (maxHeapForSmallNum.size() == minHeapForLargeNum.size()) {
          return maxHeapForSmallNum.peek() / 2.0 + minHeapForLargeNum.peek() / 2.0;
        }

        return maxHeapForSmallNum.peek();
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        FindMedianFromDataStream medianOfStream = new FindMedianFromDataStream();
        medianOfStream.insertNum(35);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(22);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(30);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(25);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(1);
        System.out.println(medianOfStream.findMedian());
    }
}

package concepts.kwaymerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given an mm number of sorted lists in ascending order and an integer, k, find the kthkth smallest number among all the given lists.

    Although there can be repeating values in the lists, each element is considered unique and, therefore, contributes to calculating
    the kth smallest element.

    If k is greater than the total number of elements in the input lists, return the greatest element from all the lists, and if there
    are no elements in the input lists, return 0.

    Constraints:
        1) 1 ≤  m ≤ 50
        2) 0 ≤ list[i].length ≤ 50
        3) −10^9 ≤ list[i][j] ≤ 10^9
        4) 1 ≤ k ≤ 10^9
 */
public class KWaySmallestNumberInSortedLists {
    /*
     * Naive Approach: Merge all lists into a single list and sort it. Then return the kth element (1-based index).
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int findKthSmallest_naive(List<List<Integer>> lists, int k) {
        // Merge all lists into a single list
        List<Integer> mergedList = new ArrayList<>();
        for (List<Integer> list : lists) {
            for (int num : list) {
                mergedList.add(num);
            }
        }

        // Edge case: If the merged list is empty, return 0
        if (mergedList.isEmpty()) {
            return 0;
        }

        // Sort the merged list
        Collections.sort(mergedList);

        // Check if k is within the bounds of the merged list
        if (k <= mergedList.size()) {
            return mergedList.get(k - 1); // kth smallest element (1-based index)
        } else {
            return mergedList.get(mergedList.size() - 1); // Largest element
        }
    }

    /*
     * Optimized Approach: Use a min heap to find the kth smallest element.
     * Time Complexity: O((m + k) log m)
     * Space Complexity: O(m)
     */
    public static int findKthSmallest_optimized(List<List<Integer>> lists, int k) {
        int listLength = lists.size();
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int index = 0; index < listLength; index++) {
            // if there are no elements in the input lists, continue
            if (lists.get(index).isEmpty()) {
                continue;
            } else {
                // placing the first element of each list in the min-heap
                kthSmallest.offer(new int[] {lists.get(index).get(0), index, 0});
            }
        }

        // set a counter to match if our kth element equals to that counter, return that number
        int numbersChecked = 0;
        int smallestNumber = 0;
        
        // iterating over the elements pushed in our min-heap
        while (!kthSmallest.isEmpty()) {
            // get the smallest number from top of heap and its corresponding list and index
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[2];
            numbersChecked++;

            if (numbersChecked == k) {
                break;
            }

            // if there are more elements in list of the top element, add the next element of that list to the min-heap
            if (numIndex + 1 < lists.get(smallest[1]).size()) {
                kthSmallest.offer(new int[] {lists.get(listIndex).get(numIndex + 1), listIndex, numIndex + 1});
            }
        }

        return smallestNumber;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        int k = 5;
        System.out.println(findKthSmallest_naive(lists, k));

        lists = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        k = 5;
        System.out.println(findKthSmallest_optimized(lists, k));
    }
}

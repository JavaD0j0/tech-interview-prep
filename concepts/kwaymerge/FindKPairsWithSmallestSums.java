package concepts.kwaymerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given two lists, and an integer k, find k pairs of numbers with the smallest sum so that in each pair, each list contributes 
    one number to the pair.

    Constraints:
        1) 1 ≤ list1.length, list2.length ≤ 500
        2) −10^4 ≤ list1[i], list2[i] ≤ 10^4
        3) 1 ≤ k ≤ 10^3
        4) Input lists should be sorted in ascending order.
        5) If the value of k exceeds the total number of valid pairs that may be formed, return all the pairs.
 */
public class FindKPairsWithSmallestSums {
    public static List<List<Integer>> kSmallestPairs_naive(int[] list1, int[] list2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        // Generate all pairs and their sums
        for (int num1 : list1) {
            for (int num2 : list2) {
                pairs.add(Arrays.asList(num1, num2));
            }
        }

        // Sort pairs based on the sum of elements in each pair
        Collections.sort(pairs, Comparator.comparingInt(pair -> pair.get(0) + pair.get(1)));

        // Return the first k pairs, or all pairs if k is greater than the number of pairs
        return pairs.subList(0, Math.min(k, pairs.size()));
    }

    /*
     * Time Complexity: O((n + k) log k) -> simpliflied to O(n log k)
     * Space Complexity: O(k), where k = min(n, k)
     */
    public static List<List<Integer>> kSmallestPairs_optimized(int[] list1, int[] list2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        int listLength = list1.length;

        // declaring a min-heap to keep track of the smallest sums
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < Math.min(k, listLength); i++) {
            // computing sum of pairs all elements of list1 with first index of list2 and placing it in the min-heap
            minHeap.add(new Pair(list1[i] + list2[0], i, 0));
        }

        int counter = 1;
        // iterate over elements of min-heap and only go upto k
        while (!minHeap.isEmpty() && counter <= k) {
            // placing sum of the top element of min-heap and its corresponding pairs in i and j
            Pair pair = minHeap.poll();
            int i = pair.i;
            int j = pair.j;
            pairs.add(Arrays.asList(list1[i], list2[j]));

            // increment the index for 2nd list, as we've compared all possible pairs with the 1st index of list2
            int nextElement = j + 1;
            // if next element is available for list2 then add it to the heap
            if (list2.length > nextElement) {
                minHeap.add(new Pair(list1[i] + list2[nextElement], i, nextElement));
            }
            counter++;
        }

        return pairs;
    }

    private static class Pair {
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[] list1 = { 1, 7, 11 };
        int[] list2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPairs_naive(list1, list2, k));
        System.out.println(kSmallestPairs_optimized(list1, list2, k));
    }
}

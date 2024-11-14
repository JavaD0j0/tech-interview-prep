package concepts.kwaymerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
    Find the kth smallest element in an (n×n) matrix, where each row and column of the matrix is sorted in ascending order.

    Although there can be repeating values in the matrix, each element is considered unique and, therefore, contributes to calculating 
    the kth smallest element.

    Constraints:
        1) n == matrix.length
        2) n == matrix[i].length
        3) 1 ≤ n ≤ 100
        4) −10^3 ≤ matrix[i][j] ≤ 10^3
        5) 1 ≤ k ≤ n^2
 */
public class KSmallestElementInSortedMatrix {
    /*
     * Time Complexity: O(n^2 log n)
     * Space Complexity: O(n^2)
     */
    public static int kthSmallest_naive(int[][] matrix, int k) {
        List<Integer> elements = new ArrayList<>();

        // Flatten the matrix into a single list
        for (int[] row : matrix) {
            for (int num : row) {
                elements.add(num);
            }
        }

        Collections.sort(elements);

        // Retrieve the k-th smallest element (1-based index, so k-1 for 0-based)
        return elements.get(k - 1);
    }

    public static int kthSmallest_optimized(int[][] matrix, int k) {
        int rowCount = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < Math.min(rowCount, k); i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        
        int numbersChecked = 0;
        int smallestElement = 0;
        
        while (!minHeap.isEmpty()) {
            // get the smallest number from top of heap and its corresponding row and column
            int[] curr = minHeap.poll();
            smallestElement = curr[0];
            int rowIndex = curr[1];
            int colIndex = curr[2];
            numbersChecked++;

            // when numbersChecked equals k, we'll return smallestElement
            if (numbersChecked == k) {
                break;
            }
            
            // if the current element has a next element in its row, add the next element of that row to the minHeap
            if (colIndex + 1 < matrix[rowIndex].length) {
                minHeap.offer(new int[]{matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
            }
        }

        return smallestElement;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        int[][] matrix1 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 6;
        System.out.println(kthSmallest_naive(matrix1, k));

        int[][] matrix2 = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        k = 6;
        System.out.println(kthSmallest_optimized(matrix2, k));
    }
}

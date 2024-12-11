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

    /*
     * Time Complexity: O(((min(m, k) + k) * log(min(m, k))))
     * Space Complexity: O(m)
     */
    public static int kthSmallest_optimized(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Min-heap to store elements along with their row and column indices
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        
        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.add(new Element(matrix[i][0], i, 0));
        }
        
        // Extract the smallest element k times
        int result = 0;
        for (int i = 0; i < k; i++) {
            Element current = minHeap.poll();
            result = current.value;
            
            // If there is a next element in the same row, add it to the heap
            if (current.col + 1 < n) {
                minHeap.add(new Element(matrix[current.row][current.col + 1], current.row, current.col + 1));
            }
        }
        
        return result;
    }
    
    private static class Element {
        int value;
        int row;
        int col;
        
        public Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
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

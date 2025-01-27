/*
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
    /*
     * Time Complexity: O(2^(m + n))
     * Space Complexity: O(m + n)
     */
    public int uniquePathsBruteForce(int m, int n) {
        return countPathsBruteForce(0, 0, m, n);
    }

    private int countPathsBruteForce(int i, int j, int m, int n) {
        // Base case: Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }
        // Base case: Reached bottom-right corner
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        // Recursive calls: Move right and move down
        return countPathsBruteForce(i, j + 1, m, n) + countPathsBruteForce(i + 1, j, m, n);
    }

    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public int uniquePathsOptimized_2DArray(int m, int n) {
        // Create a DP table
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // The result is in the bottom-right cell
        return dp[m - 1][n - 1];
    }

    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     */
    public int uniquePathsOptimized_1DArray(int m, int n) {
        // Create a 1D array for the current row
        int[] dp = new int[n];
        // Initialize the first row with 1
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        // Update the array row by row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        // The result is in the last cell
        return dp[n - 1];
    }
}

/*
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class CountGoodNodesInBinaryTree {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(h)
     */
    public static int countGoodNodesBruteForce(TreeNode root) {
        if (root == null) return 0;
        return dfsBruteForce(root, root.val);
    }

    private static int dfsBruteForce(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int good = node.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, node.val);

        good += dfsBruteForce(node.left, maxSoFar);
        good += dfsBruteForce(node.right, maxSoFar);

        return good;
    }

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public static int countGoodNodesOptimized(TreeNode root) {
        // Start DFS from the root, with the root's value as the initial maximum
        return dfsOptimized(root, root.val);
    }

    private static int dfsOptimized(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int good = 0;
        if (node.val >= maxSoFar) {
            good = 1;
            maxSoFar = node.val;
        }

        good += dfsOptimized(node.left, maxSoFar);
        good += dfsOptimized(node.right, maxSoFar);

        return good;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

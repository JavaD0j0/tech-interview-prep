/*
 * https://leetcode.com/problems/boundary-of-binary-tree/
 */

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public List<Integer> boundaryOfBinaryTreeOptimized(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;

        // Add the root value if it's not a leaf
        if (!isLeaf(root)) {
            boundary.add(root.val);
        }

        // Add the left boundary excluding leaves
        addLeftBoundary(root.left, boundary);

        // Add all leaf nodes
        addLeaves(root, boundary);

        // Add the right boundary in reverse order excluding leaves
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    // Check if a node is a leaf
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // Add left boundary nodes excluding leaves
    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (!isLeaf(node)) {
                boundary.add(node.val); // Add non-leaf node
            }
            node = (node.left != null) ? node.left : node.right; // Move to the next boundary node
        }
    }

    // Add all leaf nodes in the tree
    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;

        // If the node is a leaf, add it
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }

        // Recursively process left and right subtrees
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }

    // Add right boundary nodes excluding leaves in reverse order
    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.val); // Add non-leaf node
            }
            node = (node.right != null) ? node.right : node.left; // Move to the next boundary node
        }
        // Reverse the collected right boundary and add to the main boundary list
        for (int i = temp.size() - 1; i >= 0; i--) {
            boundary.add(temp.get(i));
        }
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

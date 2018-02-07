/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftTree = invertTree(root.right);
        TreeNode rightTree = invertTree(root.left);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}

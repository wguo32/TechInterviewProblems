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
    public int minDepth(TreeNode root) {
        if (root == null) {
            // return Integer.MAX_VALUE;
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        if (root.left != null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null) {
            return 1 + minDepth(root.right);
        }
        return 1;
    }
}

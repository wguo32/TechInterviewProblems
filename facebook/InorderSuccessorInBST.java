/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // recursive approach
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode leftSub = inorderSuccessor(root.left, p);
        if (leftSub == null) {
            return root;
        }
        return leftSub;
    }
}

//
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        while (root != null) {
            if (root.val > p.val) {
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return suc;
    }
}

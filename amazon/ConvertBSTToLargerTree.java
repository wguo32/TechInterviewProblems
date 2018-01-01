/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // approach1: recursion
class Solution {
    int rightSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        rightSum += root.val;
        root.val = rightSum;
        convertBST(root.left);
        return root;
    }
}

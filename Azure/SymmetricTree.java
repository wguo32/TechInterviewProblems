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
    public boolean isSymmetric(TreeNode root) {
        return checkSym(root, root);
    }

    private boolean checkSym(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            return (node1.val == node2.val) && checkSym(node1.left, node2.right)
                    && checkSym(node1.right, node2.left);
    }
}

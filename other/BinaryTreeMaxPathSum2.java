/**
http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum-ii/
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

// path starts from root to any node
public class Solution {
    /*
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}

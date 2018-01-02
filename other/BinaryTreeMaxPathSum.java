/**
http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/#

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

// The path may start and end at any node in the tree.
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: An integer
     */

    class Result {
        int singlePath;
        int maxPath;
        Result(int single, int max) {
            this.singlePath = single;
            this.maxPath = max;
        }
    }
    public int maxPathSum(TreeNode root) {
        return pathHelper(root).maxPath;
    }

    public Result pathHelper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        Result leftResult = pathHelper(root.left);
        Result rightResult = pathHelper(root.right);

        int single = Math.max(Math.max(leftResult.singlePath, rightResult.singlePath), 0) + root.val;
        int max = Math.max(leftResult.maxPath, rightResult.maxPath);
        max = Math.max(
                Math.max(leftResult.singlePath, 0) +
                Math.max(rightResult.singlePath, 0) + root.val,
                max);
        return new Result(single, max);
    }
}

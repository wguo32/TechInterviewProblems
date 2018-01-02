/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // count the number of paths sum up to a number, the path could start and end at any node
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) +
            startFromRoot(root, sum);
    }

    private int startFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + startFromRoot(root.left, sum - root.val)
                            + startFromRoot(root.right, sum - root.val);
    }
}

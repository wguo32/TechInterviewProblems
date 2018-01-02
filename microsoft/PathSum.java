/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // path should be from root to leaf
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}

// cannot do it like this
// 1
//   \      对于左侧这个tree，判断是否有path sum up to 1, line 37 returns true，导致返回true。但是这并不是一个valid path。
//     2
// class Solution {
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if (root == null) {
//             return false;
//         }
//         return helper(root, sum, 0);
//     }
//     private boolean helper(TreeNode root, int sum, int curSum) {
//         if (root == null) {
//             return curSum == sum;
//         }
//         return helper(root.left, sum, curSum + root.val) ||
//                 helper(root.right, sum, curSum + root.val);
//     }
// }

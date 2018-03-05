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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);
        return helper(root.left, set, k) || helper(root.right, set, k);
    }
}

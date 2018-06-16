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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            p = stack1.pop();
            q = stack2.pop();
            if (p.val != q.val) {
                return false;
            }
            if (p.left != null) {
                stack1.push(p.left);
            }
            if (q.left != null) {
                stack2.push(q.left);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
            if (p.right != null) {
                stack1.push(p.right);
            }
            if (q.right != null) {
                stack2.push(q.right);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
        }
        return true;
    }
}

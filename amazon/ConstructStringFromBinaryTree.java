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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        buildString(t, sb);
        String result = sb.toString();
        result = result.substring(1, result.length() - 1);
        return result;
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("()");
            return;
        }
        sb.append("(").append(root.val);
        if (root.left == null && root.right == null) {
            sb.append(")");
            return;
        }
        buildString(root.left, sb);
        if (root.right != null) {
            buildString(root.right, sb);
        }
        sb.append(")");
    }
}

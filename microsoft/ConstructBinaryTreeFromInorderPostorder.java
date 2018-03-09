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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length  -1, postorder, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart) {
        if (inStart > inEnd || postStart < 0) {
            return null;
        }
        int index = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == postorder[postStart]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[postStart]);
        root.left = helper(inorder, inStart, index - 1, postorder, postStart - (inEnd - index + 1));
        root.right = helper(inorder, index + 1, inEnd, postorder, postStart - 1);
        return root;
    }
}

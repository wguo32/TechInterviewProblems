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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int index = 0; // find root from inorder
        for(int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = helper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
        return root;
    }
}

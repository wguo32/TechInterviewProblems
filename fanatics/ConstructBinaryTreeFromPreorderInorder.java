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
        if (preorder == null || preorder.length == 0 ||
            inorder == null || inorder.length == 0) {
                return null;
        }
        return helper(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
        if (inStart > inEnd || preStart >= preorder.length) {
            return null;
        }
        int index = getIndex(inorder, preorder[preStart], inStart, inEnd);
        int leftCount = index - inStart + 1;
        int preStartRight = preStart + leftCount;
        TreeNode root = new TreeNode(inorder[index]);
        root.left = helper(preorder, inorder, inStart, index - 1, preStart + 1);
        root.right = helper(preorder, inorder, index + 1, inEnd, preStartRight);
        return root;
    }

    private int getIndex(int[] nums, int num, int start, int end) {
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                index = i;
                break;
            }
        }
        return index;
    }
}

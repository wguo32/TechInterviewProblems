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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        // stack.push(root); // this is different from preorder traversal that root is pushed onto stack inititally
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}


/**
using divide and conquer and Result class
http://www.lintcode.com/en/problem/validate-binary-search-tree/
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


public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class Result {
        int min;
        int max;
        boolean isBST;
        Result(int minVal, int maxVal, boolean status) {
            this.min = minVal;
            this.max = maxVal;
            this.isBST = status;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Result leftResult = helper(root.left);
        Result rightResult = helper(root.right);
        if (!leftResult.isBST || !rightResult.isBST) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
        if ((root.left != null && leftResult.max >= root.val) ||
            (root.right != null && rightResult.min <= root.val)) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }

        return new Result(Math.min(root.val, leftResult.min),
                            Math.max(root.val, rightResult.max), true);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // approach1: recursion
class Solution {
    int rightSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        rightSum += root.val;
        root.val = rightSum;
        convertBST(root.left);
        return root;
    }
}

// approach2: using stack to do reverse inorder traversal
class Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}

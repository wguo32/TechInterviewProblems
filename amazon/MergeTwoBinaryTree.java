/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // recursive approach without creating new tree
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

// iterative approach
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] pairs = stack.pop();
            TreeNode node1 = pairs[0];
            TreeNode node2 = pairs[1];
            // only need to check the second node, because if the first node is null, it would not have been pushed onto stack
            if (node2 == null) {
                continue;
            }
            node1.val += node2.val;
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack.push(new TreeNode[] {node1.left, node2.left});
            }

            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack.push(new TreeNode[] {node1.right, node2.right});
            }
        }
        return t1;
    }
}

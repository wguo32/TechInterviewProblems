/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode node;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (node != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        TreeNode newNode = stack.pop();
        int val = newNode.val;
        node = newNode.right;
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

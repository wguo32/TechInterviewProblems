/**
http://www.lintcode.com/en/problem/lowest-common-ancestor-iii/
LCA could be null, aka, there is no LCA for the given two nodes
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
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    class Result {
        boolean foundA;
        boolean foundB;
        TreeNode node;

        Result(boolean a, boolean b, TreeNode n) {
            this.foundA = a;
            this.foundB = b;
            this.node = n;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        Result result = lcaHelper(root, A, B);
        if (result.foundA && result.foundB) {
            return result.node;
        }
        return null;
    }
    private Result lcaHelper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new Result (false, false, null);
        }
        Result left = lcaHelper(root.left, A, B);
        Result right = lcaHelper(root.right, A, B);
        boolean hasA = left.foundA || right.foundA || root == A;
        boolean hasB = left.foundB || right.foundB || root == B;

        if (root == A || root == B) {
            return new Result(hasA, hasB, root);
        }
        if (left.node != null && right.node != null) {
            return new Result(hasA, hasB, root);
        }
        if (left.node != null) {
            return new Result (hasA, hasB, left.node);
        }
        if (right.node != null) {
            return new Result(hasA, hasB, right.node);
        }
        return new Result(hasA, hasB, null);
    }
}

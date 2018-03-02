// taking care of the case that the given node does not exist in the tree

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
      private class Result {
          boolean hasA;
          boolean hasB;
          TreeNode node;

          Result(boolean a, boolean b, TreeNode n) {
              hasA = a;
              hasB = b;
              node = n;
          }
      }
      public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
          Result result = helper(root, A, B);
          if (result.hasA && result.hasB) {
              return root;
          }
          return null;
      }

      private Result helper(TreeNode root, TreeNode A, TreeNode B) {
          if (root == null) {
              return new Result(false, false, null);
          }
          Result leftRst = helper(root.left, A, B);
          Result rightRst = helper(root.right, A, B);
          if (leftRst.hasA && left.Rst.hasB) {
              return leftRst;
          }
          if (rightRst.hasA && rightRst.hasB) {
              return rightRst;
          }
          boolean curA = leftRst.hasA || rightRst.hasA;
          boolean curB = leftRst.hasB || rightRst.hasB;
          if (curA && curB) {
              return new Result(true, true, root);
          }
          return new Result(curA, curB, null);
      }
  }

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
     public boolean isSymmetric(TreeNode root) {
         if (root == null || (root.left == null && root.right == null)) {
             return true;
         }
         if (root.left == null || root.right == null) {
             return false;
         }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root.left);
         queue.offer(root.right);
         while (!queue.isEmpty()) {
             TreeNode node1 = queue.poll();
             TreeNode node2 = queue.poll();
             if (node1 == null && node2 == null) {
                 break;
             }
             if (node1 == null || node2 == null || (node1.val != node2.val)) {
                 return false;
             }
             queue.offer(node1.left);
             queue.offer(node2.right);
             queue.offer(node1.right);
             queue.offer(node2.left);
         }
         return true;
     }
 }

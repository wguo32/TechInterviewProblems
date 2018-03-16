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
     public boolean findTarget(TreeNode root, int k) {
         Set<Integer> set = new HashSet<>();
         return find(root, k, set);
     }
     private boolean find(TreeNode root, int k, Set<Integer> set) {
         if (root == null) {
             return false;
         }
         if (set.contains(k - root.val)) {
             return true;
         }
         set.add(root.val);
         return find(root.left, k, set) || find(root.right, k, set);
     }
 }


 // traverse the BST
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int left = list.get(i);
            int right = list.get(j);
            if (left + right == k) {
                return true;
            } else if (right + left < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}

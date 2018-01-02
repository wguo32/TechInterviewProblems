/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 // use backtracking, similar to subsets problem
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(result, new ArrayList<>(), root, sum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list));
        } else {
            helper(result, list, root.left, sum - root.val);
            helper(result, list, root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }
}

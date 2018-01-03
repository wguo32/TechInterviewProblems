class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }
    public class Solution {
        public int treeAmplitude(TreeNode) {
            if (root == null) {
                return 0;
            }
            return helper(root, root.val, root.val);
        }

        private int helper(TreeNode root, int min, int max) {
            if (root == null) {
                return max - min;
            }
            if (root.val < min) {
                min = root.val;
            }
            if (root.val > max) {
                max = root.val;
            }
            return Math.max(helper(root.left, min, max), helper(root.right, min, max));
        }
    }
}

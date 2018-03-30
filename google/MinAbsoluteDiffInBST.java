// inorder traversal
class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode preNode;
    public int getMinimumDifference(TreeNode root) {
        inTraversal(root);
        return minDiff;
    }

    private void inTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inTraversal(root.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, root.val - preNode.val);
        }
        preNode = root;
        inTraversal(root.right);
    }
}


class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}

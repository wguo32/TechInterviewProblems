public class Solution {
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }

        return sameTree(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    public boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
}

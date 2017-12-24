/**
DFS and hashset
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(set, root, k);
    }

    public boolean helper(Set<Integer> set, TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return helper(set, root.left, target) || helper(set, root.right, target);
    }
}

/**
BFS and hashset
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return false;
    }
}

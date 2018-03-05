/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // recursive approach with hashset
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);
        return helper(root.left, set, k) || helper(root.right, set, k);
    }
}

// nonrecursive approach with hashset and Queue
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
            if (set.contains(node.val)) {
                return true;
            }
            set.add(k - node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}

// using BST property and traverse the tree

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        traverseBST(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int first = list.get(i);
            int second = list.get(j);
            if (first + second == k) {
                return true;
            } else if (first + second < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void traverseBST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverseBST(root.left, list);
        list.add(root.val);
        traverseBST(root.right, list);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getString(root, sb);
        return sb.toString();
    }

    private void getString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        getString(root.left, sb);
        getString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> list = new LinkedList<>();
        // String[] strs = data.split(",");
        // list.addAll(Arrays.asList(strs));
        list.addAll(Arrays.asList(data.split(",")));
        return buildTree(list);
    }

    private TreeNode buildTree(Queue<String> list) {
        String str = list.remove();
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = buildTree(list);
        node.right = buildTree(list);
        return node;
    }
}

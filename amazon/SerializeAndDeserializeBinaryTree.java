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
    private static final String splitter = ",";
    private static final String nullNode = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // build the string by pre-order traversing the binary tree
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullNode).append(splitter);
            return;
        }

        sb.append(root.val).append(splitter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String str = queue.remove();
        if (str.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}

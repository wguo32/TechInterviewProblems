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
    int index = 0;
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        return helper(s.toCharArray());
    }

    private TreeNode helper(char[] chars) {
        if (index == chars.length) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        while (index < chars.length && chars[index] != '(' && chars[index] != ')') {
            sb.append(chars[index]);
            index++;
        }
        TreeNode node = null;
        if(sb.length() != 0) {
            node = new TreeNode(Integer.parseInt(sb.toString()));
        }

        if (index < chars.length && chars[index] == '(') {
            index++;
            node.left = helper(chars);
            index++;
            if (index < chars.length && chars[index] == '(') {
                index++;
                node.right = helper(chars);
                index++;
            }
        }
        return node;
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(char c : chars) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

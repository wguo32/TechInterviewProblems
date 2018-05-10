class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int leftEdge = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    leftEdge = i;
                } else {
                    int j = stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - leftEdge);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}

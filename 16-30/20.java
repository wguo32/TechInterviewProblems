class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ("([{".contains(String.valueOf(c))) {
                char complement = getComplement(s, c);
                stack.push(complement);
            } else {
                if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private Character getComplement(String s, Character c) {
        char result = ' ';
        switch (c)  {
            case '(':
                result = ')';
                break;
            case '[':
                result = ']';
                break;
            case '{':
                result = '}';
                break;
            default:
                result = ' ';
                break;
        }
        return result;
    }
}

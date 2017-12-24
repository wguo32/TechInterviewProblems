class Solution {
    public boolean isValid(String s) {
      if (s == null || s.length() == 0) {
        return true;
      }
      char[] chars = s.toCharArray();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == '(') {
          stack.push(')');
        } else if (chars[i] == '{') {
          stack.push('}');
        } else if (chars[i] == '[') {
          stack.push(']');
        } else {
          if (stack.isEmpty() || stack.pop() != chars[i]) {
            return false;
          }
        }
      }
      return stack.isEmpty();
    }
  }

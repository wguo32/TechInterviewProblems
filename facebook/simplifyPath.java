class Solution {
    String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skips = new HashSet<>(Arrays.asList("..",".",""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skips.contains(dir)) {
                stack.push(dir);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result  = "/" + stack.pop() + result;
        }
        return result.isEmpty() ? "/" : result;
    }
}

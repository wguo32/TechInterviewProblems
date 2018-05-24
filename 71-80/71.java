class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }

        Set<String> skips = new HashSet<>(Arrays.asList("", ".", ".."));
        Stack<String> stack = new Stack<>();

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skips.contains(dir)) {
                stack.push(dir);
            }
        }

        String paths = "";
        while (!stack.isEmpty()) {
            paths = "/" + stack.pop() + paths;
        }
        if (paths.length() == 0) {
            return "/";
        }
        return paths;
    }
}

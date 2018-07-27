class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean findLongest = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (validStr(str)) {
                result.add(str);
                findLongest = true;
                continue;
            }
            if(findLongest) {
                continue;
            }
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String newStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(newStr)) {
                    queue.add(newStr);
                    visited.add(newStr);
                }
            }
        }
        return result;
    }

    private boolean validStr(String str) {
        int leftCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftCount++;
            } else if (str.charAt(i) == ')') {
                leftCount--;
                if(leftCount < 0) {
                    return false;
                }
            }
        }
        return leftCount == 0;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", n, n, result);
        return result;
    }

    private void helper(String current, int left, int right,
                        List<String> result) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        if (left > 0) {
            helper(current + "(", left - 1, right, result);
        }
        if (right > 0) {
            helper(current + ")", left, right - 1, result);
        }
    }
}

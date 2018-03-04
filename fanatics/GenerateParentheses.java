class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;
    }

    private void helper(List<String> result, String curr, int remainL, int remainR) {
        if (remainL > remainR) {
            return;
        }
        if (remainL == 0 && remainR == 0) {
            result.add(curr);
            return;
        }
        if (remainL > 0) {
            helper(result, curr + "(", remainL - 1, remainR);
        }
        if (remainR > 0) {
            helper(result, curr + ")", remainL, remainR - 1);
        }
    }
}

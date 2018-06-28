class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, map, result, new StringBuilder());
        return result;
    }

    private void helper(String digits, int start, String[] map, List<String> result, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = map[digits.charAt(start) - '0'];

        for (char c : str.toCharArray()) {
            sb.append(c);
            helper(digits, start + 1, map, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

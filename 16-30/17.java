class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }

    private void backtrack(String digits, int start, StringBuilder sb, List<String> result, String[] mapping) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(start);
        char[] chars = mapping[digit - '0'].toCharArray();
        for (char c : chars) {
            sb.append(c);
            backtrack(digits, start + 1, sb, result, mapping);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

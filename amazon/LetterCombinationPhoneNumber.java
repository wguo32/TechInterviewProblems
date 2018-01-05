// recursive approach

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        buildString(result, digits, 0, mapping, sb);
        return result;
    }

    private void buildString(List<String> result, String digits, int start,
                                String[] mapping, StringBuilder sb) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String word = mapping[digits.charAt(start) - '0'];
        for(int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            buildString(result, digits, start + 1, mapping, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

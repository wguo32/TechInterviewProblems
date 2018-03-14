class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(result, 0, digits, new StringBuilder(), map);
        return result;
    }

    private void helper(List<String> result, int curIndex, String digits, StringBuilder sb,
                        Map<Character, String> map) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String curStr = map.get(digits.charAt(i));
        for(int i = 0; i < curStr.length(); i++) {
            sb.append(curStr.charAt(i));
            helper(result, curIndex + 1, digits, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

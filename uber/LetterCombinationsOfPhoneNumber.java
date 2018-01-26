class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[] {'d','e','f'});
        map.put('4', new char[] {'g','h','i'});
        map.put('5', new char[] {'j','k','l'});
        map.put('6', new char[] {'m','n','o'});
        map.put('7', new char[] {'p','q','r','s'});
        map.put('8', new char[] {'t','u','v'});
        map.put('9', new char[] {'w','x','y','z'});
        StringBuilder sb = new StringBuilder();
        helper(digits, map, 0, sb, result);
        return result;
    }

    private void helper(String digits, Map<Character, char[]> map, int start,
                        StringBuilder sb, List<String> result) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(char c : map.get(digits.charAt(start))) {
            sb.append(c);
            helper(digits, map, start + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

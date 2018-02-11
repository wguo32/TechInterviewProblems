class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}

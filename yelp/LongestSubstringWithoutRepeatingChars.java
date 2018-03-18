// using hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right])) {
                left = Math.max(left, map.get(chars[right]) + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(chars[right], right);
        }
        return maxLen;
    }
}

// using array to mark repeated chars
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] marker = new int[256];
        int maxLen = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            left = Math.max(left, marker[s.charAt(right)]);
            maxLen = Math.max(maxLen, right - left + 1);
            marker[s.charAt(right)] = right + 1;
        }
        return maxLen;
    }
}

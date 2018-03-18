class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] marker = new int[256];
        char chars = s.toCharArray();
        int maxLen = 0;
        int j = 0;
        while (j < chars.length) {
            if (marker[chars[j]] == 0) {
                marker[chars[j]] = j;
            } else {
                maxLen = Math.max(maxLen, j - marker[chars[j]]);
                marker[chars[j]] = j;
            }
            j++;
        }
        return maxLen;
    }
}


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

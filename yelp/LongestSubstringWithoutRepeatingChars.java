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

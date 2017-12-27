/**
DP
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int maxLen = 0;
        String result = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - 1 <= i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        result = s.substring(i, j + 1);
                        maxLen = j - i + 1;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }
}

/**
expand around center
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int lenMax = Math.max(len1, len2);
            if (lenMax > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandCenter(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}

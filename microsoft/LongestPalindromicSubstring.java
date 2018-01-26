// center expansion
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(i, i, s);
            int len2 = expand(i, i + 1, s);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end + 1 - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - 1 - start;
    }
}


// dynamic programming
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int max = 0;
        String result = "";
        for (int i = len - 1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j + 1 - i > max) {
                        max = j + 1 - i;
                        result = s.substring(i, j + 1);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }
}

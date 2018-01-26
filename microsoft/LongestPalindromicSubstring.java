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

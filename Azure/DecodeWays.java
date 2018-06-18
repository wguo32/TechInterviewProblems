class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int sDigit = Integer.valueOf(s.substring(i - 1, i));
            int dDigit = Integer.valueOf(s.substring(i - 2, i));
            if (sDigit > 0 && sDigit <= 9) {
                dp[i] = dp[i - 1];
            }
            if (dDigit >= 10 && dDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}

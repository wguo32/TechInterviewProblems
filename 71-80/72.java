class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] dp = new int[2][word1.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            for (int j = 1; j <= word1.length(); j++) {
                dp[i % 2][0] = i;
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1] + 1,
                                Math.min(dp[(i - 1) % 2][j] + 1, dp[i % 2][j - 1] + 1));
                }
            }
        }
        return dp[word2.length() % 2][word1.length()];
    }
}

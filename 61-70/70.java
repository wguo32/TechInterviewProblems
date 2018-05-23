class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int oneStep = 1;
        int twoStep = 1;
        int ways = 0;
        for (int i = 2; i <= n; i++) {
            ways = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = ways;
        }
        return ways;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int low = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }
}

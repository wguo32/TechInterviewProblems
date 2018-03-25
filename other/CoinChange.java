class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] changes = new int[amount + 1];

        Arrays.fill(changes, amount + 1);
        changes[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    changes[i] = Math.min(changes[i - coin] + 1, changes[i]);
                }
            }
        }
        return changes[amount] > amount ? -1 : changes[amount];
    }
}

// approach1: 2 for loops
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.set(j, 1);
                } else {
                    ArrayList<Integer> pre = list.get(i - 1);
                    curr.set(j, pre.get(j - 1) + pre.get(j));
                }
            }
            result.add(cur);
        }
        return result;
    }
}


// approach2 DP
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                list.add(dp[i][j]);
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}

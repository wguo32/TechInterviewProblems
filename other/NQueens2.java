class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        helper(new int[n], 0);
        return count;
    }

    private void helper(int[] colPositions, int row) {
        if (row == colPositions.length) {
            count++;
            return;
        }
        for (int i = 0; i < colPositions.length; i++) {
            colPositions[row] = i;
            if (isValid(colPositions, row)) {
                helper(colPositions, row + 1);
            }
        }
    }

    private boolean isValid(int[] colPositions, int row) {
        for (int i = 0; i < row; i++) {
            if (colPositions[i] == colPositions[row] ||
                Math.abs(colPositions[i] - colPositions[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        helper(new int[n], 0);
        return count;
    }

    private void helper(int[] colPos, int row) {
        if (row == colPos.length) {
            count++;
            return;
        }

        for (int i = 0; i < colPos.length; i++) {
            colPos[row] = i;
            if (isValid(colPos, row)) {
                helper(colPos, row + 1);
            }
        }
    }

    private boolean isValid(int[] colPos, int row) {
        for (int i = 0; i < row; i++) {
            if (colPos[i] == colPos[row]) {
                return false;
            }
            if (Math.abs(colPos[i] - colPos[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}

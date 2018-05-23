class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }

        helper(result, new int[n], 0);
        return result;
    }

    private void helper(List<List<String>> result, int[] colPos, int row) {
        if (row == colPos.length) {
            drawBoard(result, colPos);
            return;
        }

        for (int i = 0; i < colPos.length; i++) {
            colPos[row] = i;
            if (isValid(colPos, row)) {
                helper(result, colPos, row + 1);
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

    private void drawBoard(List<List<String>> result, int[] colPos) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < colPos.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colPos.length; j++) {
                if (j == colPos[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}

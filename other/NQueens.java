class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        helper(result, new int[n], 0);
        return result;
    }

    private void helper(List<List<String>> result, int[] colPositions,
                        int row) {
        if (row == colPositions.length) {
            addQueens(result, colPositions);
            return;
        }
        for (int i = 0; i < colPositions.length; i++) {
            colPositions[row] = i;
            if (isValid(colPositions, row)) {
                helper(result, colPositions, row + 1);
            }
        }
    }

    private boolean isValid(int[] positions, int row) {
        // col specify the row num here
        for (int i = 0; i < row; i++) {
            if (positions[i] == positions[row]) {
                return false;
            } else if (Math.abs(positions[i] - positions[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private void addQueens(List<List<String>> result, int[] colPositions) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < colPositions.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colPositions.length; j++) {
                if (colPositions[i] == j) {
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

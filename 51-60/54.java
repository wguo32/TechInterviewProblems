class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int minRow = 0, maxRow = matrix.length - 1;
        int minCol = 0, maxCol = matrix[0].length - 1;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i  = minCol; i <= maxCol; i++) {
                result.add(matrix[minRow][i]);
            }
            minRow++;
            for (int i = minRow; i <= maxRow; i++) {
                result.add(matrix[i][maxCol]);
            }
            maxCol--;

            if (minRow > maxRow || minCol > maxCol) {
                break;
            }

            for (int i = maxCol; i >= minCol; i--) {
                result.add(matrix[maxRow][i]);
            }
            maxRow--;

            for (int i = maxRow; i >= minRow; i--) {
                result.add(matrix[i][minCol]);
            }
            minCol++;
        }
        return result;
    }
}

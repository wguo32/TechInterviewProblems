class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int minR = 0, maxR = matrix.length - 1;
        int minC = 0, maxC = matrix[0].length - 1;
        while (minR <= maxR && minC <= maxC) {
            for (int i = minC; i <= maxC; i++) {
                result.add(matrix[minR][i]);
            }
            minR++;
            for (int i = minR; i <= maxR; i++) {
                result.add(matrix[i][maxC]);
            }
            maxC--;

            if (minR > maxR || minC > maxC) {
                break;
            }

            for (int i = maxC; i >= minC; i--) {
                result.add(matrix[maxR][i]);
            }
            maxR--;
            for (int i = maxR; i >= minR; i--) {
                result.add(matrix[i][minC]);
            }
            minC++;
        }
        return result;
    }
}

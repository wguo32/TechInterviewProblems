class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int maxRect = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] = heights[j] + 1;
                }
            }
            maxRect = Math.max(maxRect, maxHist(heights));
        }
        return maxRect;
    }

    private int maxHist(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxHist = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int cur = stack.pop();
                maxHist = Math.max(maxHist, heights[cur] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
            maxHist = Math.max(maxHist, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxHist;
    }
}

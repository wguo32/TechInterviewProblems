class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxRect = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxRect = Math.max(maxRect, findMaxRect(heights));
        }
        return maxRect;
    }

    private int findMaxRect(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxRect = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int cur = stack.pop();
                maxRect = Math.max(maxRect, heights[cur] * (i - stack.peek() - 1));
            }
            stack.push(heights[i]);
        }

        while (stack.peek() != -1) {
            maxRect = Math.max(maxRect, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxRect;
    }
}

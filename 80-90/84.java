// divide and conquer approach, average time complexity is O(NlgN), but worst case is O(N^2)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        return findMaxRec(heights, 0, heights.length - 1);
    }

    private int findMaxRec(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        return Math.max((end - start + 1) * heights[minIndex],
                        Math.max(findMaxRec(heights, start, minIndex - 1),
                        findMaxRec(heights, minIndex + 1, end)));
    }
}

// O(N) time complexity with stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxRec = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek()  != -1 && heights[i] <= heights[stack.peek()]) {
                int leftIndex = stack.pop();
                maxRec = Math.max(maxRec, heights[leftIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxRec = Math.max(maxRec, heights[stack.pop()] * (heights.length - stack.peek()  - 1));
        }
        return maxRec;
    }
}

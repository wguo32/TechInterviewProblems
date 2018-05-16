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

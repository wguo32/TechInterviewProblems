class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftMax = 0, rightMax = 0;
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                max += leftMax - height[i];
                i++;
            } else {
                max += rightMax - height[j];
                j--;
            }
        }
        return max;
    }
}

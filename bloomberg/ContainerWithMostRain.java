class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int newArea = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, newArea);
            if (height[right] <= height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}

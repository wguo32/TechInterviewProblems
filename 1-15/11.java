class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int maxVol = 0;
        int lower = Integer.MAX_VALUE;
        while (left < right) {
            lower = height[left] <= height[right] ? left : right;
            if ((right - left) * height[lower] > maxVol) {
                maxVol = (right - left) * height[lower];
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVol;
    }
}

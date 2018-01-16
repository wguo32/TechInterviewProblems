// sorting with time complexity O(nlogn)
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max1 = nums[0] * nums[1] * nums[len  -1];
        int max2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return Math.max(max1, max2);
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right++;
                left++;
            }
            right++;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length() == 0) {
            return;
        }

        int left = 0;
        for (int i = 0; i < nums.length(); i++) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}

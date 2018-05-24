class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int[] mark = new int[nums.length];
        mark[mark.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
                if (mark[j] == 1) {
                    mark[i] = 1;
                    break;
                }
            }
        }
        return mark[0] == 1;
    }
}

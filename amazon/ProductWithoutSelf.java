class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return new null;
        }
        int len = nums.length;
        int[] leftP = new int[len];
        int[] rightP = new int[len];

        leftP[0] = 1;
        rightP[len - 1] = 1;
        int product = nums[0];
        for (int i = 1; i < len; i++) {
            leftP[i] = leftP[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            rightP[i] = rightP[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = leftP[i] * rightP[i];
        }
        return nums;
    }
}

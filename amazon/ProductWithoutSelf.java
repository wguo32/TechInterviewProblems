class Solution {
    public int[] productExceptSelf(int[] nums) {
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

// optimized with no extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int preProduct = 1;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                preProduct *= nums[i - 1];
            }
            result[i] = preProduct;
        }
        int postProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1) {
                postProduct *= nums[i + 1];
            }
            result[i] *= postProduct;
        }
        return result;
    }
}

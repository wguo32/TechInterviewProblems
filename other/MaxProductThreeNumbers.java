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

// one pass maintaining multiple variables
class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num > max2) {
                max1 = max2;
                max2 = num;
            } else if (num > max1) {
                max1 = num;
            }
        }
        long product1 = max1 * max2 * max3;
        long product2 = min1 * min2 * max3;
        return (int)Math.max(product1, product2);
    }
}

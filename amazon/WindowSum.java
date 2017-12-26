public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int sum = 0;
        // I think it makes more sense to return the sum even if there are less than k elements,
        // but lintcode does not accept this solution
        // if (k > nums.length) {
        //     for (int num : nums) {
        //         sum += num;
        //     }
        //     return new int[]{sum};
        // }

        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k ) {
                sum += nums[i];
                result[index] = sum;
            } else {
                sum = sum + nums[i] - nums[i - k];
                result[++index] = sum;
            }
        }
        return result;
    }
}

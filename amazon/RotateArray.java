/**
This problem is also an interview problem by Facebook
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }

        int step = k % nums.length;
        reverse(nums, 0, nums.length - step - 1);
        reverse(nums, nums.length - step, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

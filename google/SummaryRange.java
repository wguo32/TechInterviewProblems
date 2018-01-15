class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        int start = 0, end = 0;
        while (end < nums.length) {
            end++;
            while (end < nums.length && nums[end - 1] + 1 == nums[end]) {
                end++;
            }
            if (start != end - 1) {
                result.add(nums[start] + "->" + nums[end - 1]);
            } else {
                result.add(nums[start] + "");
            }
            start = end;
        }
        return result;
    }
}

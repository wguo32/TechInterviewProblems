class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||
            nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] intersect = new int[result.size()];
        int index = 0;
        for (int num : result) {
            intersect[index++] = num;
        }
        return intersect;
    }
}

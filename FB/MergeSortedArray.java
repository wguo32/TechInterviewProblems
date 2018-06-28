class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (index >= 0 && m >= 0 && n >= 0) {
            if (nums2[n] > nums1[m]) {
                nums1[index--] = nums2[n];
                n--;
            } else {
                nums1[index--] = nums1[m];
                m--;
            }
        }
        if (n >= 0) {
            while (n >= 0) {
                nums1[index--] = nums2[n--];
            }
        }
    }
}

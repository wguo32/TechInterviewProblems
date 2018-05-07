class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid1 = (len1 + len2 + 1) / 2, mid2 = (len1 + len2 + 2) / 2;
        return (findKth(nums1, 0, len1, nums2, 0, len2, mid1) +
                findKth(nums1, 0, len1, nums2, 0, len2, mid2)) / 2;
    }

    private double findKth(int[] nums1, int start1, int remainLen1, int[] nums2, int start2, int remainLen2, int k) {
        if (remainLen1 > remainLen2) {
            return findKth(nums2, start2, remainLen2, nums1, start1, remainLen1, k);
        }

        if (remainLen1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int i = Math.min(remainLen1, k / 2);
        int j = Math.min(remainLen2, k / 2);
        if (nums1[start1 + i - 1] < nums2[start2 + j - 1]) {
            return findKth(nums1, start1 + i, remainLen1 - i, nums2, start2, remainLen2, k - i);
        } else {
            return findKth(nums1, start1, remainLen1, nums2, start2 + j, remainLen2 - j, k - j);
        }
    }
}

class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int m = nums1.length, n = nums2.length;
    //     int mid1 = (m + n + 1) / 2;
    //     int mid2 = (m + n + 2) / 2;
    //     return (findKth(nums1, 0, m, nums2, 0, n, mid1) +
    //             findKth(nums1, 0, m, nums2, 0, n, mid2)) / 2;
    // }
    //
    // private int findKth(int[] A, int start1, int len1, int[] B, int start2, int len2, int k) {
    //     // len is the available steps before going the the end of array
    //     if  (len1 > len2) {
    //         return findKth(B, start2, len2, A, start1, len1, k);
    //     }
    //     if (len1 == 0) {
    //         return B[start2 + k - 1];
    //     }
    //     if (k == 1) {
    //         return Math.min(A[start1], B[start2]);
    //     }
    //
    //     int moveSteps1 = Math.min(len1, k / 2);
    //     int moveSteps2 = Math.min(len2, k / 2);
    //     if (A[start1 + moveSteps1 - 1] < B[start2 + moveSteps2 - 1]) {
    //         return findKth(A, start1 + moveSteps1, len1 - moveSteps1,
    //                         B, start2, len2, k - moveSteps1);
    //     } else {
    //         return findKth(A, start1, len1,
    //                         B, start2 + moveSteps2, len2 - moveSteps2, k - moveSteps2);
    //     }
    // }
    public double findMedianSortedArrays(int[] A1, int[] A2) {
        int m = A1.length, n = A2.length;
        int mid1 = (m + n + 1) / 2, mid2 = (m + n + 2) / 2; // if m + n is odd number, mid1 == mid2
        return (findKth(A1, 0, m, A2, 0, n, mid1) + findKth(A1, 0, m, A2, 0, n, mid2)) / 2;
    }

    private double findKth(int[] A1, int s1, int m, int[] A2, int s2, int n, int k) {
        if (m > n) return findKth(A2, s2, n, A1, s1, m, k);
        if (m == 0) return A2[s2 + k - 1];
        if (k == 1) return Math.min(A1[s1], A2[s2]);

        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (A1[s1 + i - 1] < A2[s2 + j - 1]) {
            return findKth(A1, s1 + i, m - i, A2, s2, n, k - i);
        } else {
            return findKth(A1, s1, m, A2, s2 + j, n - j, k - j);
        }
    }
}

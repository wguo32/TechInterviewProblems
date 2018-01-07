// divide and conquer
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return lcp(strs, 0, strs.length - 1);
    }

    private String lcp(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = start + (end - start) / 2;
        String left = lcp(strs, start, mid);
        String right = lcp(strs, mid + 1, end);
        int i = 0, len1 = left.length(), len2 = right.length();
        char[] lefts = left.toCharArray();
        char[] rights = right.toCharArray();
        while(i < len1 && i < len2) {
            if (lefts[i] != rights[i]) {
                break;
            }
            i++;
        }
        return left.substring(0, i);
    }
}

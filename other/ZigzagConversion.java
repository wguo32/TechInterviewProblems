// referenced this post https://segmentfault.com/a/1190000005751185
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        int num = numRows * 2 - 2;
        int initDist = num;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            printStr(s, num, i, initDist, sb);
            initDist -= 2;
        }
        return sb.toString();
    }

    private void printStr(String s, int num, int start, int initDist, StringBuilder sb) {
        while (start < s.length()) {
            if (initDist == 0) {
                initDist = num;
            }
            sb.append(s.charAt(start));
            start += initDist;
            initDist = num - initDist;
        }
    }
}

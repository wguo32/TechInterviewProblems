class Solution {
    public int titleToNumber(String s) {
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            num = num * 26 + s.charAt(i) - 'A' + 1;
            i++;
        }
        return num;
    }
}

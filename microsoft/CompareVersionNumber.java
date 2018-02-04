class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();

        int i = 0, j = 0;
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int num1 = 0, num2 = 0;
        while (i < len1 || j < len2) {
            while (i < len1 && chars1[i] != '.') {
                num1 = num1 * 10 + (chars1[i] - '0');
                i++;
            }

            while (j < len2 && chars2[j] != '.') {
                num2 = num2 * 10 + (chars2[j] - '0');
                j++;
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                num1 = 0;
                num2 = 0;
                i++;
                j++;
            }
        }
        return 0;
    }
}

class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1;
        int result = 0;
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit  = str.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return sign * result;
    }
}

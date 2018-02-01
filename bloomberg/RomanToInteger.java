Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = convert(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            result += convert(c);
            if (convert(s.charAt(i - 1)) < convert(c)) {
                result -= 2 * convert(s.charAt(i - 1));
            }
        }
        return result;
    }

    private int convert (char c) {
        int val = 0;
        switch (c) {
            case 'I':
                val = 1;
                break;
            case 'V':
                val = 5;
                break;
            case 'X':
                val = 10;
                break;
            case 'L':
                val = 50;
                break;
            case 'C':
                val = 100;
                break;
            case 'D':
                val = 500;
                break;
            case 'M':
                val = 1000;
                break;
            default:
                val = 0;
        }
        return val;
    }
}

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }

        int len1 = a.length(), len2 = b.length();
        if (len1 > len2) {
            return addBinary(b, a);
        }
        int carry = 0, sum = 0;
        int num1, num2;
        StringBuilder sb = new StringBuilder();

        while (len1 > 0) {
            num1 = a.charAt(len1 - 1) - '0';
            num2 = b.charAt(len2 - 1) - '0';
            sum = carry + num1 + num2;
            sb.append(sum % 2);
            carry = sum / 2;
            len1--;
            len2--;
        }

        while (len2 > 0) {
            num2 = b.charAt(len2 - 1) - '0';
            sum = carry + num2;
            sb.append(sum % 2);
            carry = sum / 2;
            len2--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

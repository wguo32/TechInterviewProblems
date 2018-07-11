class Solution {
    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null ||
            num1.length() == 0 || num2.length() == 0) {
                return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int low = i + j + 1;
                int high = i + j;
                int sum = product + result[low];
                result[low] = sum % 10;
                result[high] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || sb.length() != 0) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

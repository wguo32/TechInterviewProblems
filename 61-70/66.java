class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len];

        reverseArray(digits);

        int carry = 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = carry + digits[i];
            result[i] = sum % 10;
            carry = sum / 10;
        }
        reverseArray(result);

        if (carry > 0) {
            int[] longResult = new int[len + 1];
            longResult[0] = carry;
            for (int i = 0; i < len; i++) {
                longResult[i + 1] = result[i];
            }
            return longResult;
        } else {
            return result;
        }
    }

    private void reverseArray(int[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

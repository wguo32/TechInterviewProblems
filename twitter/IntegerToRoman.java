class Solution {
    public String intToRoman(int num) {
        String[] tokens = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(tokens[i]);
            }
            i++;
        }
        return sb.toString();
    }
}

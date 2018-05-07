class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}

// another way to handle overflow
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x > 0) {
            int cur = result * 10 + x % 10;
            if (cur - x % 10) / 10 != result) {
                return 0;
            }
            result = cur;
            x = x / 10;
        }
        return result;
    }
}

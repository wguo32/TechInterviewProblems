class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        // to avoid overflow
        long dividendL = (long)dividend;
        long divisorL = (long)divisor;
        int sign = 1;

        // convert to non-negative numbers
        if (divisorL < 0) {
            divisorL = -divisorL;
            sign = -sign;
        }
        if (dividendL < 0) {
            dividendL = -dividendL;
            sign = -sign;
        }

        int result = 0;
        while (dividendL >= divisorL) {
            int shift = 0;
            while (dividendL >= divisorL << shift) {
                shift++;
            }
            result += 1 << (shift - 1);
            dividendL -= divisorL << (shift - 1);
        }
        return sign * result;
    }
}

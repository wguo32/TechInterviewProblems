class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / (x * myPow(x, -(n + 1)));
        }

        double result = 1;
        while (n > 1) {
            if (n  % 2 == 1) {
                result *= x;
            }
            n /= 2;
            x = x * x;
        }
        result *= x;
        return result;
    }
}

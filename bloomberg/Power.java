class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double curProduct = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                result = result * curProduct;
            }
            curProduct = curProduct * curProduct;
        }
        return result;
    }
}

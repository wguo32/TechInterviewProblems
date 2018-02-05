class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int result = 0;
            while (n > 0) {
                result += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }
        return true;
    }
}

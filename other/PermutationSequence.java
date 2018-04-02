class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int leadingIndex = k / factorial[i - 1];
            k = k % factorial[i - 1];
            sb.append(list.get(leadingIndex));
            list.remove(leadingIndex);
        }
        return sb.toString();
    }
}

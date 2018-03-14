class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, k, n, 1, new ArrayList<>());
        return result;
    }

    private void helper(List<List<Integer>> result, int num, int n,
                        int start, List<Integer> list) {
        if (num == 0) {
            result.add(new ArrayList<>(list));
        }
        if (start > n) {
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(result, num - 1, n, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

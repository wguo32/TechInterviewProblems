class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        findComb(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void findComb(int[] candidates, int target, int sum, int start,
                            List<Integer> list, List<List<Integer>> result) {
        if (start >= candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            findComb(candidates, target, sum + candidates[i], i, list, result);
            list.remove(list.size() - 1);
        }
    }
}

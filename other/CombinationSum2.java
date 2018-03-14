class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int targetCur, int start, List<Integer> list,
                        List<List<Integer>> result) {
        if (targetCur < 0) {
            return;
        }
        if (targetCur == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, targetCur - candidates[i], i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}

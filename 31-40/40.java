class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        findComb2(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void findComb2(int[] candidates, int start, int sum, int target,
                            List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            findComb2(candidates, i + 1, sum + candidates[i], target, list, result);
            list.remove(list.size() - 1);
        }

    }
}

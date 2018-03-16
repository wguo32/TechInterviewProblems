// memoization using hashmap
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return helper(input, memo);
    }

    private List<Integer> helper(String input, Map<String, List<Integer>> memo) {
        List<Integer> result = new ArrayList<>();
        if (memo.containsKey(input)) {
            return memo.get(input);
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> ll = memo.getOrDefault(left, helper(left, memo));
                List<Integer> rl = memo.getOrDefault(right, helper(right, memo));
                for (int num1 : ll) {
                    for (int num2 : rl) {
                        switch (c) {
                            case '+':
                                result.add(num1 + num2);
                                break;
                            case '-':
                                result.add(num1 - num2);
                                break;
                            case '*':
                                result.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        memo.put(input, result);
        return result;
    }
}

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return helper(input, map);
    }

    private List<Integer> helper(String input, Map<String, List<Integer>> map) {
        List<Integer> result = new ArrayList<>();
        if (map.containsKey(input)) {
            return map.get(input);
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> ll = map.getOrDefault(left, helper(left, map));
                List<Integer> rl = map.getOrDefault(right, helper(right, map));
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
        map.put(input, result);
        return result;
    }
}

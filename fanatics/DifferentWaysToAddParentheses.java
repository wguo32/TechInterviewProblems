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
                String strL = input.substring(0, i);
                String strR = input.substring(i + 1, input.length());
                List<Integer> listL = map.getOrDefault(strL, helper(strL, map));
                List<Integer> listR = map.getOrDefault(strR, helper(strR, map));
                for (int numL : listL) {
                    for (int numR : listR) {
                        switch (c) {
                            case '+':
                                result.add(numL + numR);
                                break;
                            case '-':
                                result.add(numL - numR);
                                break;
                            case '*':
                                result.add(numL * numR);
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

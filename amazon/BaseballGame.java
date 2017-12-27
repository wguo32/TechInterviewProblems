class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<Integer> points = new Stack<>();
        int sum = 0;
        int top = 0;
        for (String str : ops) {
            if (str.equals("+")) {
                top = points.pop();
                int newValue = points.peek() + top;
                points.push(top);
                points.push(newValue);
                sum += newValue;
            }  else if (str.equals("C")) {
                top = points.pop();
                sum -= top;
            } else if (str.equals("D")) {
                top = points.peek();
                points.push(top * 2);
                sum += top * 2;
            }  else {
                int num = Integer.valueOf(str);
                points.push(num);
                sum += num;
            }
        }
        return sum;
    }
}

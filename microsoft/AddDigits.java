// recursive approach
class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        if (sum >= 10) {
            return addDigits(sum);
        } else {
            return sum;
        }
    }
}


// iterative approach
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int result = 0;
            while (num != 0) {
                result += num % 10;
                num = num / 10;
            }
            num = result;
        }
        return num;
    }
}

public class ConvertNumber {
    public static String convert(char[] result, int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(baseDigit(num % base));
            num /= base;
        }
        return reverse(sb.toString());
    }

    private static char baseDigit (int num) {
        if (num >= 0 && num <= 9) {
            return (char)(num + '0');
        } else {
            return (char)(num - 10 + 'A');
        }
    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        int num = 35;
        int base = 36;
        char[] result = new char[100];
        System.out.println(convert(result, num, base));
    }
}

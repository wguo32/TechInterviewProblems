import java.util.Scanner;

public class StringCompression {
    public static String compress(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j < s.length()) {
            char cur = chars[j];
            int count = 0;
            while (j < s.length() && chars[j] == cur) {
                j++;
                count++;
            }
            chars[i++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[i++] = c;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(compress(str));
    }
}

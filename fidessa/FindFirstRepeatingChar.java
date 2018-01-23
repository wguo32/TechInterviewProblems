import java.util.Scanner;

public class FindFirstRepeatingChar {
    public static char findFirstRepeatingChar(String s) {
        if (s == null || s.length() <= 1) {
            return ' ';
        }
        int[] table = new int[256];

        for (char c : s.toCharArray()) {
            table[c]++;
        }

        for (char c : s.toCharArray()) {
            if (table[c] > 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(findFirstRepeatingChar(str));
    }
}

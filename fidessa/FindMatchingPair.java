import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class FindMatchingPair {
    public static int match(String input) {
        if (input == null || input.length() == 0) {
            return -1;
        }
        int result = -1;
        Deque<Character> dq = new LinkedList<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(chars[i])) {
                break;
            }

            if (Character.isUpperCase(chars[i])) {
                dq.add(chars[i]);
            } else {

                if (dq.isEmpty()) {
                    break;
                } else {
                    if (dq.peekLast() == Character.toUpperCase(chars[i])) {
                        result = i;
                        dq.removeLast();
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(match(str));
    }
}

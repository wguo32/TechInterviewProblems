/**
 * Created by shanfang on 12/19/17.
 */
public class EvenOddPattern {
    public static void printPattern(int num) {
        int i, print = 0;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++) { // forget this curly braces
                System.out.println(print);
                print += 2;
            }
        } else {
            print = 1;
            for (i = 0; i < num; i++) { // same error
                System.out.println(print);
                print += 2;
            }
        }
    }

    public static void main(String[] args) {
        printPattern(5);
    }
}


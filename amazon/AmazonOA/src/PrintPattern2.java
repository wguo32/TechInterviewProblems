/**
 * Created by shanfang on 12/19/17.
 */
public class PrintPattern2 {
    public static void print2(int row) {
        // char ch = 'a';
        // char print  = ch;

        for (int i = 0; i < row; i++) {
            char ch = 'a';
            char print  = ch;
            for (int j = 0; j <=i; j++) {
                System.out.print(print++);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        print2(5);
    }
}


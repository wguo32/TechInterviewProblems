import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();
        for (int i = 0; i < lines; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a < 0 || b < 0 || c < 0) {
                System.out.println("None of these");
                continue;
            }
            if (a + b <= c || b + c <= a || a + c <= b) {
                System.out.println("None of these");
            } else if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a == b || b == c || a ==c) {
                System.out.println("Isosceles");
            } else {
                System.out.println("None of these");
            }
        }
    }
}

// implemented using array
class Stack {
    static final int MAX = 100;
    int top;
    int arr[] = new int[MAX];

    // constructor
    Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return top < 0;
    }

    boolean push(int num) {
        if (num >= MAX) {
            return false;
        } else {
            arr[++top] = num;
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int num = arr[top--];
            return num;
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        System.out.println("The stack is initially empty: " + s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop() + " is popped from stack");
    }
}

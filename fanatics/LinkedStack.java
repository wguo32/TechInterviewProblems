// use Linked List to implement Stack
import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedStack {
    private Node top;
    private int size;

    private class Node {
        Node next;
        int val;

        Node() {
            next = null;
            val = 0;
        }
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node next) {
            this.next = next;
        }
    }

    LinkedStack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(int num) {
        Node newNum = new Node(num);
        newNum.next = top;
        top = newNum;
        size++;
        System.out.println(num + " is pushed onto stack");
        return true;
    }

    public int pop() {
        if (size <= 0) {
            throw new NoSuchElementException("Stack underflow");
        }
        int topVal = top.val;
        top = top.next;
        size--;
        return topVal;
    }

    public int peek() {
        if (size <= 0) {
            throw new NoSuchElementException("Stack underflow");
        }
        return top.val;
    }

    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Integer> {
        private Node current = top;

        public boolean hasNext() {
            return top != null;
        }
        
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int value = top.val;
            top = top.next;
            size--;
            return new Integer(value);
        }
    }
    public static void main(String args[]) {
        LinkedStack s = new LinkedStack();
        System.out.println("The stack is initially empty: " + s.isEmpty());
        // System.out.println(s.pop() + " is popped from stack");
        s.push(1);
        s.push(2);
        s.push(3);
        Iterator<Integer> it = s.iterator();
        System.out.println("Find top of stack using iterator, top is: " + it.next());
        System.out.println("Now top of stack is: " + s.peek());
        System.out.println(s.pop() + " is popped from stack");
    }
}

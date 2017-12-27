/**
not tested
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class ReverseSecondHalfLinkedList {
    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next, pre = null;
        while (tail != null) {
            ListNode temp = tail.next;
            tail.next = pre;
            pre = tail;
            tail = temp;
        }
        slow.next = pre;
        return head;
    }
    public static void main(String args[]) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ReverseSecondHalfLinkedList reverse = new ReverseSecondHalfLinkedList();
        reverse.reverseSecondHalfList(head);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("Null");
    }
}

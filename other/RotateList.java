/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode tail = new ListNode(0);
        tail.next = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        int move = len - k % len;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (move > 0) {
            dummy = dummy.next;
            move--;
        }
        tail.next = head;
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}

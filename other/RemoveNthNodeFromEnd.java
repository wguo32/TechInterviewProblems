/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        len = len - n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = dummy;
        while (len > 0) {
            cur = cur.next;
            len--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}

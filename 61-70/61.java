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
        if (head == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (k >= len) {
            k = k % len;
            if (k == 0) {
                return head;
            }
        }

        ListNode pre = head, post = head;
        int step = 0;
        while (step < k) {
            pre = pre.next;
            step++;
        }

        while (pre.next != null) {
            pre = pre.next;
            post = post.next;
        }

        ListNode newHead = post.next;
        post.next = null;
        pre.next = head;

        return newHead;
    }
}

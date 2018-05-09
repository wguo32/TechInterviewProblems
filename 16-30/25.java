/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        while (count < k && pre != null) {
            pre = pre.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        ListNode cur = reverseKGroup(pre, k);
        while (count > 0) {
            ListNode temp = head.next;
            head.next = cur;
            cur = head;
            head = temp;
            count--;
        }
        head = cur;
        return head;
    }
}

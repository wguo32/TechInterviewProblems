/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && pre.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            if (cur == null) {
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}

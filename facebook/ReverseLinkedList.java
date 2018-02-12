/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // recursive approach
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        return helper(pre, head);
    }

    private ListNode helper(ListNode pre, ListNode head) {
        if (head == null) {
            return pre;
        }
        ListNode nextNode = head.next;
        head.next = pre;
        return helper(head, nextNode);

    }
}

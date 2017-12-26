/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // iterative approach
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode pos = head.next;
            head.next = pre;
            pre = head;
            head = pos;
        }
        return pre;
    }
}

// recursive approach
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        return reverseHelper(head, pre);
    }

    public ListNode reverseHelper(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return reverseHelper(next, head);
    }
}

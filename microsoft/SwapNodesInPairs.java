/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode post = head;
        while (post != null && post.next != null) {
            ListNode temp = post.next.next;
            pre.next = post.next;
            post.next.next = post;
            post.next = temp;
            pre = post;
            post = temp;
        }
        return dummy.next;
    }
}

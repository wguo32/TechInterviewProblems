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

        ListNode pre = head, post = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (post != null) {
            while (post != null && post.val == pre.val) {
                post = post.next;
            }
            if (post == null) {
                pre.next = null;
                break;
            }
            pre.next = post;
            pre = post;
            post = post.next;
        }
        return dummy.next;
    }
}

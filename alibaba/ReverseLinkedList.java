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
        ListNode dummy = null;
        ListNode pre = dummy;
        ListNode post = head;
        while (post != null) {
            ListNode temp = post.next;
            post.next = pre;
            pre = post;
            post = temp;
        }
        return pre;
    }
}

// recursive approach
class Solution {
   public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode nextNode = head.next;
       ListNode newHead = reverseList(nextNode);
       nextNode.next = head;
       head.next = null;
       return newHead;
   }
}

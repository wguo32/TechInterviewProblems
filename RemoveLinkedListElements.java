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
     public ListNode removeElements(ListNode head, int val) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         head = dummy;

         while (head.next != null) {
             if (head.next.val == val) {
                 head.next = head.next.next;
             } else {
                 head = head.next;
             }
         }
         return dummy.next;
     }
 }

 // recursive approach
 class Solution {
     public ListNode removeElements(ListNode head, int val) {
         if (head == null) {
             return null;
         }
         head.next = removeElements(head.next, val);
         return head.val == val ? head.next : head;
     }
 }

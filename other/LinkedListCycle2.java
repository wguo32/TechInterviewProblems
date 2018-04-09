/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {
     public ListNode detectCycle(ListNode head) {
         if (head == null || head.next == null) {
             return null;
         }
         ListNode intersection = getIntersection(head);
         if (intersection == null) {
             return null;
         }
         ListNode first = head, second = intersection;
         while (first != second) {
             first = first.next;
             second = second.next;
         }
         return first;
     }
     public ListNode getIntersection(ListNode head) {
         if (head == null || head.next == null) {
             return null;
         }
         ListNode slow = head, fast = head;
         while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if (fast == slow) {
                 return slow;
             }
         }
         return null;
     }
 }

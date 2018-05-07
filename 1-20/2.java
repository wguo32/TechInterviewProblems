/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + carry;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l3 = l3.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            l3.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

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
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(value);
            curr.next = newNode;
            curr = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int value = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                ListNode newNode = new ListNode(value);
                l2 = l2.next;
                curr.next = newNode;
                curr = newNode;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                int value = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                ListNode newNode = new ListNode(value);
                l1 = l1.next;
                curr.next = newNode;
                curr = newNode;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}

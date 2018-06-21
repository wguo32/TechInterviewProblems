/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // divide and conquer with O(1) space complexity and O(kN) time complexity
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divideConq(lists, 0, lists.length - 1);
    }

    private ListNode divideConq(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode first = divideConq(lists, start, mid);
        ListNode second = divideConq(lists, mid + 1, end);
        return mergeTwoLists(first, second);
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        while (first != null && second != null) {
            if (first.val < second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        if (first == null) {
            pre.next = second;
        }
        if (second == null) {
            pre.next = first;
        }
        return dummy.next;
    }
}
